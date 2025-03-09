package core.networking.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Scanner;

public class UdpServer {
    public static void main(String[] args) {
        new Thread(() -> {
            Scanner scanner = new Scanner(System.in);
            System.out.print("type exit to shutdown: ");
            String exit = scanner.nextLine();
            if (exit.equalsIgnoreCase("exit")) {
                System.exit(0);
            }
        }).start();

        try (DatagramSocket dSocket = new DatagramSocket(5000)) {
            System.out.println("UDP server is running...");

            byte[] receiveBuffer = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);

            while (true) {
                try {
                    dSocket.receive(receivePacket);
                    String message = new String(receivePacket.getData(), 0, receivePacket.getLength());
                    System.out.println("Client: " + message);

                    if (message.equalsIgnoreCase("EXIT")) {
                        System.out.println("Shutting down server.. ");
                        break;
                    }
                    String response = "Server received " + message;
                    byte[] responseBuffer = response.getBytes();
                    DatagramPacket responsePacket = new DatagramPacket(responseBuffer, responseBuffer.length, receivePacket.getAddress(), receivePacket.getPort());
                    dSocket.send(responsePacket);

                } catch (IOException e) {
                    System.out.println("Error " + e.getMessage());
                }
            }
        } catch (SocketException e) {
            System.out.println("Error " + e.getMessage());
        }
    }
}
