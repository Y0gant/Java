package core.networking;

import java.io.*;
import java.net.Socket;

public class ClientSide {
    private Socket socket;
    private BufferedReader userInput;
    private DataOutputStream output;
    private DataInputStream serverInput;

    ClientSide(String address, int port) {
        try {
            socket = new Socket(address, port);
            System.out.println("Connected to server");

            userInput = new BufferedReader(new InputStreamReader(System.in));
            output = new DataOutputStream(socket.getOutputStream());
            serverInput = new DataInputStream(socket.getInputStream());

            String line = "";
            while (!line.equals("END")) {
                System.out.print("Enter message: ");
                line = userInput.readLine();

                output.writeUTF(line);
                output.flush();

                String response = serverInput.readUTF();
                System.out.println("Server: " + response);
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (userInput != null) userInput.close();
                if (output != null) output.close();
                if (serverInput != null) serverInput.close();
                if (socket != null) socket.close();
            } catch (IOException e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new ClientSide("127.0.0.1", 5000);
    }
}
