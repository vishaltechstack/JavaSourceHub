package Virtual_Threads;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class VirtualThreadExecutorDemo {

    public static void main(String[] args) {

        int totalTasks = 10_000;
        Instant start = Instant.now();

        // try-with-resources automatically calls executor.close(), which waits for ALL 10,000
        // virtual threads to finish before moving past the try block!
        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {

            IntStream.range(0, totalTasks).forEach(taskId -> {
                executor.submit(() -> {
                    try {
                        // Simulates a blocking network/database call taking 500ms.
                        // While sleeping, this virtual thread unmounts from its carrier OS thread!
                        Thread.sleep(Duration.ofMillis(500));
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    return taskId;
                });
            });

        } // Blocks here until all 10,000 tasks complete

        Instant end = Instant.now();
        long elapsedMs = Duration.between(start, end).toMillis();

        // 10,000 tasks each sleeping 500ms finish in ~600-800ms total on a handful of OS cores!
        System.out.println("Completed " + totalTasks + " concurrent blocking tasks in: " + elapsedMs + " ms");
    }
}