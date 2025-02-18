package core.filehandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileOperations implements FileHandler {

    public String name;
    String written;
    Scanner scanner;


    FileOperations() {
        scanner = new Scanner(System.in);
    }

    @Override
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

    @Override
    public void writeToFile(File file) {
        System.out.println("Enter text to write into the file :");
        written = scanner.nextLine();
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(written);
            System.out.println("Successfully wrote into the file");

        } catch (IOException e) {
            System.out.println("Error occurred!!");
            e.printStackTrace();
        }
    }

    @Override
    public void readFile(File toRead) {
        try {
            Scanner reader = new Scanner(toRead);
            while (reader.hasNext()) {
                String data = reader.nextLine();
                System.out.println(data);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!!");
        }
    }

    public void deleteFile(File toDelete) {
        if (toDelete.delete()) {
            System.out.println("The deleted file is : " + toDelete.getName());
        } else {
            System.out.println(
                    "Failed in deleting the file.");
        }
    }

    @Override
    public void closeScanner() {
        scanner.close();
    }

}
