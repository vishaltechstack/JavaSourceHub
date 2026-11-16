package Virtual_Threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

class SafeAccountService {

    private int balance = 1000;
    // ReentrantLock prevents carrier thread pinning during blocking calls inside critical sections
    private final ReentrantLock lock = new ReentrantLock();

    public void processTransaction(String workerName, int amount) {
        lock.lock(); // Acquires the lock cleanly
        try {
            System.out.println(workerName + " acquired lock on " + Thread.currentThread());
            Thread.sleep(100); // Safe to block here—virtual thread can unmount cleanly!
            balance += amount;
            System.out.println(workerName + " updated balance to: " + balance);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            // ALWAYS unlock inside a finally block so the lock is never stuck forever
            lock.unlock();
        }
    }
}

public class ReentrantLockOverSynchronized {

    public static void main(String[] args) {
        SafeAccountService service = new SafeAccountService();

        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            executor.submit(() -> service.processTransaction("Task-A", 500));
            executor.submit(() -> service.processTransaction("Task-B", 300));
        }
    }
}