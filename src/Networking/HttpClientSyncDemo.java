package Networking;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class HttpClientSyncDemo {

    public static void main(String[] args) {

        // 1. Build a reusable HttpClient instance with a connection timeout
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .connectTimeout(Duration.ofSeconds(10))
                .build();

        try {
            // --- PART A: Synchronous HTTP GET Request ---
            HttpRequest getRequest = HttpRequest.newBuilder()
                    .uri(URI.create("https://jsonplaceholder.typicode.com/posts/1"))
                    .header("Accept", "application/json")
                    .timeout(Duration.ofSeconds(5))
                    .GET()
                    .build();

            System.out.println("=== Sending Synchronous GET Request ===");
            // .send() blocks the current thread until the response arrives
            HttpResponse<String> getResponse = client.send(
                    getRequest,
                    HttpResponse.BodyHandlers.ofString() // Converts response bytes directly into a String
            );

            System.out.println("GET Status Code: " + getResponse.statusCode());
            System.out.println("GET Response Body:\n" + getResponse.body());

            // --- PART B: Synchronous HTTP POST Request (Sending JSON Body) ---
            String jsonPayload = """
                    {
                        "title": "Core Java Networking",
                        "body": "Learning modern HttpClient in Java",
                        "userId": 101
                    }
                    """;

            HttpRequest postRequest = HttpRequest.newBuilder()
                    .uri(URI.create("https://jsonplaceholder.typicode.com/posts"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(jsonPayload))
                    .build();

            System.out.println("\n=== Sending Synchronous POST Request ===");
            HttpResponse<String> postResponse = client.send(
                    postRequest,
                    HttpResponse.BodyHandlers.ofString()
            );

            System.out.println("POST Status Code: " + postResponse.statusCode()); // 201 Created
            System.out.println("POST Response Body:\n" + postResponse.body());

        } catch (IOException | InterruptedException e) {
            if (e instanceof InterruptedException) {
                Thread.currentThread().interrupt();
            }
            System.out.println("HTTP request failed: " + e.getMessage());
        }
    }
}