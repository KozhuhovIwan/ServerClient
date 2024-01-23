package org.example;

import java.net.*;
import java.io.*;

public class Server {
    public static void main(String[] args) throws IOException {

        int count = 0;

        ServerSocket serverSocket = new ServerSocket(8000);
        System.out.println("Server started");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client accepted " + (++count));

            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            BufferedReader reader = new BufferedReader( new InputStreamReader(clientSocket.getInputStream()));

            String request = reader.readLine();
            String response = "#" + count + ", your message length is " + request.length();

            writer.write(response);
            writer.newLine();
            writer.flush();

            reader.close();
            writer.close();
            clientSocket.close();

        }
    }
}