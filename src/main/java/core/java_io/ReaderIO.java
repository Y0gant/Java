package core.java_io;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.Reader;
import java.nio.CharBuffer;
import java.util.Arrays;

public class ReaderIO {
    public static void main(String[] args) {
        try {
            // Create a FileReader object to read from the file "Panigale.txt"
            Reader r = new FileReader("Panigale.txt");

            // PrintStream to output messages to the console
            PrintStream out = System.out;

            // Create a character buffer of size 10 to store read characters
            char[] buffer = new char[10];

            // Wrap the character buffer into a CharBuffer
            CharBuffer charBuffer = CharBuffer.wrap(buffer);

            // Check if mark() method is supported by the reader
            if (r.markSupported()) {
                r.mark(100); // Mark the current position in the stream with a read limit of 100 characters
                out.println("mark supported"); // Inform that mark() is supported
            }

            // Skip the first 5 characters in the file
            r.skip(5);

            // Check if the stream is ready to be read
            if (r.ready()) {
                // Read 10 characters from the reader and store them in the buffer array
                r.read(buffer, 0, 10);
                out.println("Buffer after reading 10 characters: " + Arrays.toString(buffer));

                // Read characters into the CharBuffer
                r.read(charBuffer);
                out.println("CharBuffer Contents: " + Arrays.toString(charBuffer.array()));

                // Read and print the next character after previous reads
                out.println("Next character: " + (char) r.read());
            }

            // Close the reader to release resources
            r.close();

        } catch (IOException e) {
            // Handle exceptions by throwing a runtime exception
            throw new RuntimeException(e);
        }
    }
}