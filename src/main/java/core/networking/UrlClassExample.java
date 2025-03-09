package core.networking;

import java.net.URI;
import java.net.URISyntaxException;

public class UrlClassExample {
    public static void main(String[] args) {
        try {
            URI uri = new URI("https://www.geeksforgeeks.org/java-networking/");
            System.out.println("Host: " + uri.getHost());
            System.out.println("Path: " + uri.getPath());
            System.out.println("Port: " + uri.getPort());
        } catch (URISyntaxException e) {
            System.out.println("Error " + e.getMessage());
        }
    }
}
