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

            String message;
            String response;

            while (true) {
                System.out.println("Enter message: ");
                message = userInput.readLine();
                outputStream.writeUTF(message);
                outputStream.flush();

                if (message.equals("END")) {
                    break;
                }

                System.out.print("Waiting for server response...");

                response = inputStream.readUTF();
                System.out.print("\r                             \r");
                System.out.println("Server: " + response);

                if (response.equals("END")) {
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("Error!! " + e.getMessage());
        }
    }
}
