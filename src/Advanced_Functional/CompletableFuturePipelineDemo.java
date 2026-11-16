package Advanced_Functional;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class CompletableFuturePipelineDemo {

    // Simulates fetching raw user data asynchronously
    private static CompletableFuture<String> fetchUserEmailAsync(int userId) {
        return CompletableFuture.supplyAsync(() -> {
            simulateDelay(300);
            if (userId <= 0) {
                throw new IllegalArgumentException("Invalid User ID: " + userId);
            }
            return "vishal.sharma@example.com";
        });
    }

    // Simulates looking up reward points using the fetched email (dependent async call)
    private static CompletableFuture<Integer> fetchRewardPointsAsync(String email) {
        return CompletableFuture.supplyAsync(() -> {
            simulateDelay(300);
            return email.startsWith("vishal") ? 1250 : 100;
        });
    }

    private static void simulateDelay(int ms) {
        try {
            TimeUnit.MILLISECONDS.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) {

        System.out.println("=== 1. Chaining Dependent Async Stages ===");

        CompletableFuture<Void> pipeline = fetchUserEmailAsync(101)
                // thenCompose() flattens a nested CompletableFuture (like flatMap in Streams!)
                .thenCompose(email -> {
                    System.out.println("Fetched Email: " + email);
                    return fetchRewardPointsAsync(email);
                })
                // thenApply() transforms the result synchronously (like map in Streams)
                .thenApply(points -> "Total Reward Value: Rs. " + (points * 0.5))
                // exceptionally() catches any exception thrown anywhere upstream and provides a fallback
                .exceptionally(ex -> "Fallback Response -> Error: " + ex.getCause().getMessage())
                // thenAccept() consumes the final result (terminal action)
                .thenAccept(System.out::println);

        // .join() waits for the non-blocking pipeline to complete before main() exits
        pipeline.join();

        System.out.println("\n=== 2. Testing Error Recovery in Async Pipeline ===");
        fetchUserEmailAsync(-5)
                .thenApply(String::toUpperCase)
                .exceptionally(ex -> "Recovered gracefully from: " + ex.getCause().getMessage())
                .thenAccept(System.out::println)
                .join();
    }
}