package core.networking.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(5000)) {
            System.out.println("Server listening to port 5000");

            Socket socket = server.accept();
            System.out.println("Connected");
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

            new Thread(() -> {

                try {
                    while (true) {
                        String response;
                        response = inputStream.readUTF();
                        System.out.println("Client: " + response);
                        if (response.equals("EXIT")) {
                            System.exit(0);
                        }
                    }
                } catch (IOException e) {
                    System.out.println("Error " + e.getMessage());
                } finally {
                    System.exit(0);
                }


            }).start();

            String message;
            while (true) {
                message = userInput.readLine();
                outputStream.writeUTF(message);
                outputStream.flush();

                if (message.equals("EXIT")) {
                    System.exit(0);
                }
            }

        } catch (IOException e) {
            System.out.println("Error " + e.getMessage());
        }

    }
}
