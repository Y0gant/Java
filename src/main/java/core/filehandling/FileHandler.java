package core.filehandling;

import java.io.File;

public interface FileHandler {
    File createFile();

    void closeScanner();

    void writeToFile(File file);

    void readFile(File toRead);

    void deleteFile(File toDelete);
}
