package core.filehandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {
    public static void main(String[] args) {
        ReadFile file1 = new ReadFile();
        CreateFile file2 = new CreateFile();
        WriteFile file3 = new WriteFile();
        File read = file2.createFile();
        file3.writeToFile(read);
        file1.readFile(read);
    }

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
}
