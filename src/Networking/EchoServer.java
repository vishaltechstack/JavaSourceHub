package Networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    public static void main(String[] args) {
        int port = 5000;

        // 1. ServerSocket opens port 5000 and listens for incoming TCP connections
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("TCP Server started on port " + port + ". Waiting for a client...");

            // 2. .accept() blocks until a client connects, then returns a dedicated Socket for that client
            try (Socket clientSocket = serverSocket.accept();
                 // Reader to receive incoming text lines from the client
                 BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                 // Writer to send text lines back to the client ('true' enables auto-flush)
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

                System.out.println("Client connected from IP: " + clientSocket.getInetAddress());

                String receivedMessage;
                // 3. Read messages continuously until client sends "BYE" or disconnects
                while ((receivedMessage = in.readLine()) != null) {
                    System.out.println("Client says: " + receivedMessage);

                    if ("BYE".equalsIgnoreCase(receivedMessage)) {
                        out.println("Server: Goodbye! Closing connection.");
                        break;
                    }

                    // Echo response back to the client in uppercase
                    out.println("Server Echo -> " + receivedMessage.toUpperCase());
                }
            }

        } catch (IOException e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }
}