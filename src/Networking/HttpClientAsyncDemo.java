package Networking;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class HttpClientAsyncDemo {

    public static void main(String[] args) {

        HttpClient client = HttpClient.newHttpClient();

        List<String> urls = Arrays.asList(
                "https://jsonplaceholder.typicode.com/users/1",
                "https://jsonplaceholder.typicode.com/users/2",
                "https://jsonplaceholder.typicode.com/users/3"
        );

        System.out.println("Firing " + urls.size() + " HTTP requests asynchronously in parallel...\n");

        // 1. Map each URL to a non-blocking CompletableFuture via sendAsync()
        List<CompletableFuture<String>> futures = urls.stream()
                .map(url -> {
                    HttpRequest request = HttpRequest.newBuilder()
                            .uri(URI.create(url))
                            .GET()
                            .build();

                    return client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                            .thenApply(response -> "URL: " + url + " | Status: " + response.statusCode() +
                                    " | Body Length: " + response.body().length() + " chars");
                })
                .collect(Collectors.toList());

        // 2. Combine all futures using CompletableFuture.allOf() and wait for all to complete
        CompletableFuture<Void> allDone = CompletableFuture.allOf(
                futures.toArray(new CompletableFuture[0])
        );

        allDone.thenRun(() -> {
            System.out.println("=== All Async Responses Received ===");
            futures.forEach(future -> System.out.println(future.join()));
        }).join(); // Wait for final print before main() exits
    }
}