package core.networking;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class InetAddressExample {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Host Address: ");
        String hostname = scanner.nextLine();
        printIPAddress(hostname);

        printLocalHostDetails();
    }

    public static void printIPAddress(String hostname) {
        try {
            InetAddress address = InetAddress.getByName(hostname);
            System.out.println("Hostname: " + hostname);
            System.out.println("IP Address: " + address.getHostAddress());
        } catch (UnknownHostException e) {
            System.err.println("Unable to resolve host: " + hostname);
        }
    }

    public static void printLocalHostDetails() {
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println("Local Hostname: " + localHost.getHostName());
            System.out.println("Local IP Address: " + localHost.getHostAddress());
        } catch (UnknownHostException e) {
            System.err.println("Unable to retrieve local host details.");
        }
    }


}
