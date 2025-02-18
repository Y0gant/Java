package core.filehandling;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class CreateFile {
    public String name;
    Scanner scanner;

    public CreateFile() {
        scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        CreateFile file1 = new CreateFile();
        File myFile = file1.createFile();
        System.out.println("Returned file object :" + myFile.getAbsolutePath());
        file1.closeScanner();
    }

    public File createFile() {
        System.out.println("Enter File name :");
        name = scanner.nextLine();
        File obj = null;
        try {
            obj = new File(name);
            if (obj.createNewFile()) {
                System.out.println("File created :" + obj.getName());
            } else {
                System.out.println("File already exists!!");
            }
        } catch (IOException e) {
            System.out.println("Error occurred - File creation failed");
            e.printStackTrace();
        }
        return obj;
    }

    public void closeScanner() {
        scanner.close();
    }
}
