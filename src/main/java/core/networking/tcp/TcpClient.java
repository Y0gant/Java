package core.networking.tcp;

import java.io.*;
import java.net.Socket;

public class TcpClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("127.0.0.1", 5000)) {

            System.out.println("Connected to server");
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

            new Thread(() -> {
                String response;
                try {
                    while (true) {
                        response = inputStream.readUTF();
                        System.out.println("Server: " + response);
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
