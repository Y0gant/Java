package core.filehandling;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class CreateFile {
    public static void main(String[] args) {
        CreateFile file1 = new CreateFile();
        System.out.println("Enter File name :");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        File myFile = file1.createFile(name);
        System.out.println("Returned file object :" + myFile.getAbsolutePath());
    }

    public File createFile(String name) {
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
}
