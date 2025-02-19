package core.filehandling;

import java.io.*;
import java.util.Scanner;

public class FileHandling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String filepath = "example.txt";

        try {
            File file = new File(filepath);
            if (file.createNewFile()) {
                System.out.println("File created " + file.getName());
            } else {
                System.out.println("File already exists");
            }
            FileWriter writer = new FileWriter(file);
            writer.write("Hello, this is a File Handling demo in Java.\n");
            writer.write("Learning about FileDescriptor, FilePermission, and various File Operations.\n");
            writer.flush();
            writer.close();
            System.out.println("Data written ");

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
            bufferedWriter.write("This line is added using BufferedWriter.\n");
            bufferedWriter.close();
            System.out.println("Written using BufferedWriter");

            FileOutputStream fos = new FileOutputStream(file, true);
            String byteData = "Writing using FileOutputStream.\n";
            fos.write(byteData.getBytes());
            fos.close();
            System.out.println("Data written using FileOutputStream.");

            FileReader reader = new FileReader(file);
            System.out.println("\n File Content (Using FileReader):");
            int ch;
            while ((ch = reader.read()) != -1) {
                System.out.print((char) ch);
            }
            reader.close();


            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            System.out.println("\n\n📖 File Content (Using BufferedReader):");
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            bufferedReader.close();


            System.out.println("\n File Properties:");
            System.out.println("File Name: " + file.getName());
            System.out.println("Absolute Path: " + file.getAbsolutePath());
            System.out.println("File Size: " + file.length() + " bytes");
            System.out.println("Is File Writable? " + file.canWrite());
            System.out.println("Is File Readable? " + file.canRead());


            FilePermission permission = new FilePermission(filepath, "read,write");
            System.out.println("\n File Permissions: " + permission.getActions());

            FileOutputStream fos2 = new FileOutputStream(file, true);
            FileDescriptor fd = fos2.getFD();
            fd.sync();
            System.out.println(" FileDescriptor sync completed.");
            System.out.println(" Is FileDescriptor valid? " + fd.valid());
            fos2.close();


            File directory = new File(".");
            System.out.println("Files in current directory :");
            String[] files = directory.list();
            for (String f : files) {
                System.out.println(f);
            }


            System.out.println("\n Do you want to delete the file? (yes/no):");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("yes")) {
                if (file.delete()) {
                    System.out.println("successfully deleted");
                } else {
                    System.out.println("Failed to delete the file.");
                }
            } else {
                System.out.println("File retained");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            scanner.close();
        }


    }
}
