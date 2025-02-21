package core.java_io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamExample {

    public static void main(String[] args) {
        try (FileInputStream fi = new FileInputStream("Panigale.txt")) {

            System.out.println("Channel :" + fi.getChannel());

            System.out.println("File description :" + fi.getFD());

            fi.skip(4);

            System.out.println("Size of file " + fi.available() + " bytes");

            System.out.println("File contents :");

            int ch;
            while ((ch = fi.read()) != -1) {
                System.out.print((char) ch);
            }
            System.out.println();

        } catch (FileNotFoundException e) {
            System.out.println("File not found: Ensure 'file1.txt' exists in the working directory. " + e.getLocalizedMessage());
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }

}
