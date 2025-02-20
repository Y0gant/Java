package core.java_io;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

public class Writer_IO {
    public static void main(String[] args) throws IOException {

        // Create a Writer object using PrintWriter to write to the console (System.out)
        Writer write = new PrintWriter(System.out);

        System.out.println("Example 1: append(char)");

        write.append('H');
        write.append('e');
        write.append('l');
        write.append('l');
        write.append('o');
        write.flush(); // Flush the writer to ensure data is written to the console
        System.out.println(); // Move to the next line for readability


        System.out.println("Example 2: append(CharSequence)");

        CharSequence t = "Hello there!!"; // Define a CharSequence
        write.append(t); // Append the entire CharSequence
        write.flush();
        System.out.println();


        System.out.println("Example 3: append(CharSequence, start, end)");

        write.append(t, 0, 5); // Append "Hello" (characters from index 0 to 4)
        write.append(" ");     // Append a space
        write.append(t, 6, 12); // Append "there" (characters from index 6 to 11)
        write.flush();

        System.out.println(); // Move to a new line for output formatting

        // Close the writer to free system resources
        write.close();
    }
}
