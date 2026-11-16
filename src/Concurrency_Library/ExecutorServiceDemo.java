package Concurrency_Library;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceDemo {

    public static void main(String[] args) {

        // 1. Create a fixed thread pool with 2 reusable worker threads
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // 2. Callable<Integer> is like Runnable, except it returns a result and can throw checked exceptions
        Callable<Integer> sumTask1 = () -> {
            System.out.println("Calculating batch 1 on: " + Thread.currentThread().getName());
            Thread.sleep(400);
            return 100 + 200;
        };

        Callable<Integer> sumTask2 = () -> {
            System.out.println("Calculating batch 2 on: " + Thread.currentThread().getName());
            Thread.sleep(400);
            return 300 + 400;
        };

        try {
            // 3. Submit tasks and receive Future placeholders for results
            Future<Integer> future1 = executor.submit(sumTask1);
            Future<Integer> future2 = executor.submit(sumTask2);

            // 4. .get() blocks until the computation finishes and retrieves the returned value
            int grandTotal = future1.get() + future2.get();
            System.out.println("Combined Result: " + grandTotal);

        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Task execution error: " + e.getMessage());
        } finally {
            // 5. ALWAYS shut down the ExecutorService, otherwise the JVM stays alive indefinitely
            executor.shutdown();
        }
    }
}