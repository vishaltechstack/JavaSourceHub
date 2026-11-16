package Networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class EchoClient {

    public static void main(String[] args) {
        String serverHost = "127.0.0.1"; // Localhost (your own computer)
        int serverPort = 5000;

        // 1. Socket initiates a TCP 3-way handshake with the server at 127.0.0.1:5000
        try (Socket socket = new Socket(serverHost, serverPort);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            System.out.println("Connected to TCP Server!");

            String[] messagesToSend = {
                    "Hello from Core Java Client!",
                    "TCP guarantees ordered delivery.",
                    "BYE"
            };

            // 2. Send each message and print the server's immediate reply
            for (String msg : messagesToSend) {
                System.out.println("Sending: " + msg);
                out.println(msg);

                String serverReply = in.readLine();
                System.out.println("Received: " + serverReply + "\n");
            }

        } catch (IOException e) {
            System.out.println("Client connection failed (Is EchoServer running?): " + e.getMessage());
        }
    }
}