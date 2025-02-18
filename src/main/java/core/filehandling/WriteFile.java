package core.filehandling;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WriteFile {
    Scanner sc;
    String written;

    WriteFile() {
        sc = new Scanner(System.in);
    }

    public static void main(String[] args) {
        CreateFile file1 = new CreateFile();
        File file = file1.createFile();
        WriteFile writable = new WriteFile();

        if (file != null) {
            writable.writeToFile(file);
        }


        file1.closeScanner();

    }


    public void writeToFile(File file) {
        System.out.println("Enter text to write into the file :");
        written = sc.nextLine();
        try (FileWriter writer = new FileWriter(file);) {
            writer.write(written);
            System.out.println("Successfully wrote into the file");

        } catch (IOException e) {
            System.out.println("Error occurred!!");
            e.printStackTrace();
        }
    }

}
