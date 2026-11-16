package Virtual_Threads;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class StructuredTaskFanOutDemo {

    // Simulated blocking microservice calls
    private static String fetchUserProfile(int userId) throws InterruptedException {
        Thread.sleep(300);
        return "User[id=" + userId + ", name=Vishal]";
    }

    private static String fetchUserOrders(int userId) throws InterruptedException {
        Thread.sleep(400);
        return "Orders[count=5, total=Rs.14,200]";
    }

    public static void main(String[] args) {

        // Structured Fan-Out: Launch parallel virtual threads and join them as one cohesive unit
        try (ExecutorService vtExecutor = Executors.newVirtualThreadPerTaskExecutor()) {

            // 1. Fork two independent blocking subtasks onto separate Virtual Threads
            CompletableFuture<String> profileFuture = CompletableFuture.supplyAsync(() -> {
                try {
                    return fetchUserProfile(101);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                }
            }, vtExecutor);

            CompletableFuture<String> ordersFuture = CompletableFuture.supplyAsync(() -> {
                try {
                    return fetchUserOrders(101);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                }
            }, vtExecutor);

            // 2. Join both subtasks together: blocks until both succeed, or fails immediately if either throws
            CompletableFuture<String> combinedDashboard = profileFuture.thenCombine(
                    ordersFuture,
                    (profile, orders) -> "Dashboard Ready -> " + profile + " | " + orders
            );

            System.out.println(combinedDashboard.get());

        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Structured task failed cleanly: " + e.getMessage());
        }
    }
}