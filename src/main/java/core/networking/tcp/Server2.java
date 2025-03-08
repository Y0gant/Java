package core.networking.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server2 {
    private Socket socket;
    private ServerSocket serverSocket;
    private DataOutputStream outputStream;
    private DataInputStream inputStream;
    private BufferedReader userInput;

    public Server2(int port) {
        try {
            // Create a ServerSocket object
            this.serverSocket = new ServerSocket(port);
            System.out.println("Server started waiting for client....");

            // Accept client connection
            socket = serverSocket.accept();
            System.out.println("Connected");

            // Create the input/output streams
            outputStream = new DataOutputStream(socket.getOutputStream());
            inputStream = new DataInputStream(socket.getInputStream());
            userInput = new BufferedReader(new InputStreamReader(System.in));

            String line;
            String clientMessage;

            // Communication loop
            while (true) {
                System.out.print("Waiting for client message..");
                // Read message from client
                clientMessage = inputStream.readUTF();
                System.out.print("\r                              \r");
                System.out.println("Client: " + clientMessage);

                // Check if client wants to end connection
                if (clientMessage.equals("END")) {
                    break;
                }

                // Get server response
                System.out.print("Enter Message: ");
                line = userInput.readLine();

                // Send response to client
                outputStream.writeUTF(line);
                outputStream.flush();

                // Check if server wants to end connection
                if (line.equals("END")) {
                    break;
                }
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                // Close all resources
                if (socket != null) socket.close();
                if (serverSocket != null) serverSocket.close();
                if (outputStream != null) outputStream.close();
                if (inputStream != null) inputStream.close();
                if (userInput != null) userInput.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new Server2(5000);
    }
}