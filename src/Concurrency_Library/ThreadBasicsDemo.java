package Concurrency_Library;

// 1. Defining a task by implementing the Runnable functional interface
class DownloadTask implements Runnable {
    private String fileName;

    public DownloadTask(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void run() {
        for (int progress = 25; progress <= 100; progress += 25) {
            System.out.println(Thread.currentThread().getName() + " downloading " + fileName + ": " + progress + "%");
            try {
                Thread.sleep(300); // Pauses current thread for 300ms to simulate work
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

public class ThreadBasicsDemo {

    public static void main(String[] args) throws InterruptedException {

        // 2. Creating Thread objects wrapping our Runnable tasks
        Thread t1 = new Thread(new DownloadTask("Java_Guide.pdf"), "Worker-1");
        Thread t2 = new Thread(new DownloadTask("Architecture.zip"), "Worker-2");

        // 3. ALWAYS call .start(), NEVER .run()!
        // .start() creates a new call stack for parallel execution; .run() runs on main thread.
        t1.start();
        t2.start();

        // 4. .join() forces the 'main' thread to wait until t1 and t2 finish
        t1.join();
        t2.join();

        System.out.println("All downloads completed! Main thread exiting.");
    }
}