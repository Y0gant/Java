package core.filehandling;

// Java Program to display all
// the contents of a directory

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;


public class AllDirectory {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter directory path : ");
        String directoryPath = br.readLine();

        System.out.print("Enter the directory name : ");
        String directoryName = br.readLine();

        File fileObject = new File(directoryPath, directoryName);


        if (fileObject.exists()) {

            String[] arr = fileObject.list();

            int n = arr.length;

            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
                File f1 = new File(fileObject, arr[i]);

                if (f1.isFile()) System.out.println(": is a file");
                if (f1.isDirectory()) System.out.println(": is a directory");
            }

            System.out.println("\nNo of entries in this directory : " + n);
        } else System.out.println("Directory not found");
    }
}
