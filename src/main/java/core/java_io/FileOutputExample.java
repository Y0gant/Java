package core.java_io;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FileOutputExample {
    public static void main(String[] args) {
        String data = " \n";
        Scanner scanner = new Scanner(System.in);
        try (FileOutputStream fos = new FileOutputStream("output.txt", true)) {
            // Convert string to bytes
            byte[] byteData = data.getBytes();
            System.out.println("Input text to insert in file");
            String inp = scanner.nextLine();
            byte[] byteInp = inp.getBytes();
            // Write bytes to file
            fos.write(byteData);
            fos.write(byteInp);
            System.out.println("Data written to file successfully.");


            BufferedReader read = new BufferedReader(new FileReader("output.txt"));
            String line;


            while ((line = read.readLine()) != null) {
                System.out.println(line);
            }

            read.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

