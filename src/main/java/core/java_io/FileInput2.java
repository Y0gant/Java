package core.java_io;

import java.io.*;

public class FileInput2 {
    public static void main(String[] args) {
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("output.txt"))) {
            bos.write("This is an example of BufferedOutputStream.".getBytes());
            System.out.println("Data written to file successfully.");

            for (int i = 65; i < 75; i++) {
                bos.write(i);
            }
            byte[] b = {75, 76, 77, 78, 79, 80};
            bos.write(b);
            bos.flush();

            BufferedReader read = new BufferedReader(new FileReader("output.txt"));

            String line;
            while ((line = read.readLine()) != null) {
                System.out.println(line);
            }
            read.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
