package core.networking;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressExample {

    public static void main(String[] args) {
        String hostname = "www.google.com";
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

    public static String getIPAddress(String hostname) {
        try {
            InetAddress address = InetAddress.getByName(hostname);
            return address.getHostAddress();
        } catch (UnknownHostException e) {
            return null;
        }
    }
}
