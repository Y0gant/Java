package core.filehandling;

import java.io.File;

public class FileHandlerExample {
    public static void main(String[] args) {
        FileHandler fileHandler = new FileOperations();
        File createdFile = fileHandler.createFile();
        fileHandler.writeToFile(createdFile);
        fileHandler.readFile(createdFile);
        fileHandler.deleteFile(createdFile);
        fileHandler.closeScanner();
        File file2 = new File("D:\\Programming\\Java\\Panigale.txt");
        fileHandler.readFile(file2);
    }
}
