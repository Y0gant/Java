package core.networking;

import java.io.*;
import java.net.Socket;

public class Client2 {
    private Socket socket;
    private DataInputStream inputStream;
    private DataOutputStream outputStream;
    private BufferedReader reader;

    Client2(String hostName, int port) {
        try {
            socket = new Socket(hostName, port);
            System.out.println("Connected to server");

            reader = new BufferedReader(new InputStreamReader(System.in));
            inputStream = new DataInputStream(socket.getInputStream());
            outputStream = new DataOutputStream(socket.getOutputStream());

            String line;
            String serverResponse;

            // Communication loop
            while (true) {
                // Get client message
                System.out.print("Enter Message: ");
                line = reader.readLine();

                // Send message to server
                outputStream.writeUTF(line);
                outputStream.flush();

                // Check if client wants to end connection
                if (line.equals("END")) {
                    break;
                }
                System.out.print("Waiting for server message..");

                // Read server response
                serverResponse = inputStream.readUTF();
                System.out.print("\r                              \r");
                System.out.println("Server: " + serverResponse);

                // Check if server wants to end connection
                if (serverResponse.equals("END")) {
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                // Close all resources
                if (socket != null) socket.close();
                if (inputStream != null) inputStream.close();
                if (outputStream != null) outputStream.close();
                if (reader != null) reader.close();
            } catch (IOException e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new Client2("127.0.0.1", 5000);
    }
}