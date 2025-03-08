package core.networking.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(5000)) {
            System.out.println("Server listening to port 5000");

            Socket socket = server.accept();
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

            String message;
            String response;

            while (true) {
                System.out.print("Waiting for client response...");
                response = inputStream.readUTF();
                System.out.print("\r                             \r");
                System.out.println("Client: " + response);

                if (response.equals("END")) {
                    break;
                }

                System.out.print("Enter Message: ");
                message = userInput.readLine() + "\n";
                outputStream.writeUTF(message);
                outputStream.flush();

                if (message.equals("END")) {
                    break;
                }
            }

        } catch (IOException e) {
            System.out.println("Error! " + e.getMessage());
        }

    }
}
