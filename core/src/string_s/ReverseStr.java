package src.string_s;

import java.util.Scanner;

/**
 * This reverses a user inputted string
 * using the concat() method
 */

public class ReverseStr {
    public static void main(String[] args) {
        //Creating a new scanner object
        Scanner scn = new Scanner(System.in);
        // Take a string as input
        String input = scn.nextLine();
        // Initialize a string variable to store reversed string
        String reverse = "";
        //iterate string in reverse order
        for (int i = input.length() - 1; i >= 0; i--) {
            // a character variable to store the
            // characters from last to first index of string
            char ch = input.charAt(i);
            //convert character to string variable
            String ch2 = Character.toString(ch);
            //use concat() method on the reverse string to
            // combine the sequence of characters that will
            //give us a reversed string
            reverse = reverse.concat(ch2);
        }
        System.out.println(reverse);
    }

}
