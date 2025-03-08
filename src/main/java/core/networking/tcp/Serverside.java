package core.networking.tcp;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Serverside {
    private ServerSocket server;
    private Socket socket;
    private DataInputStream input;
    private DataOutputStream output;

    public Serverside(int port) {
        try {
            server = new ServerSocket(port);
            System.out.println("Server started, waiting for client...");

            socket = server.accept();
            System.out.println("Client connected");

            input = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            output = new DataOutputStream(socket.getOutputStream());

            String line = "";
            while (!line.equals("END")) {
                try {
                    line = input.readUTF();
                    System.out.println("Client: " + line);

                    output.writeUTF("Received: " + line);
                    output.flush();
                } catch (IOException e) {
                    System.out.println("Connection error: " + e.getMessage());
                    break;
                }
            }

        } catch (IOException e) {
            System.out.println("Server error: " + e.getMessage());
        } finally {
            try {
                if (input != null) input.close();
                if (output != null) output.close();
                if (socket != null) socket.close();
                if (server != null) server.close();
            } catch (IOException e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new Serverside(5000);
    }
}
