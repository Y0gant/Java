package core.networking.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UdpClient {
    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket()) {
            InetAddress address = InetAddress.getByName("127.0.0.1");

            Scanner scanner = new Scanner(System.in);
            byte[] sendBuffer;
            byte[] receiveBuffer = new byte[1024];

            while (true) {
                System.out.print("Enter message: ");
                String message = scanner.nextLine();

                sendBuffer = message.getBytes();

                DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, address, 5000);
                socket.send(sendPacket);

                if (message.equalsIgnoreCase("exit")) {
                    System.out.println("Client exiting...");
                    break;
                }
                DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
                socket.receive(receivePacket);
                String response = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Server: " + response);
            }
        } catch (IOException e) {
            System.out.println("Error " + e.getMessage());

        }
    }
}
