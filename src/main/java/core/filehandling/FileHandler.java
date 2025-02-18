package core.filehandling;

import java.io.File;

public interface FileHandler {
    public abstract File createFile();

    public abstract void closeScanner();

    public abstract void writeToFile(File file);

    public abstract void readFile(File toRead);

    public abstract void deleteFile(File toDelete);
}
