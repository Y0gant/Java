package core.practice;

import java.util.Scanner;

public class NumberGuess {
    public static void guessNumber() {
        Scanner scanner = new Scanner(System.in);
        int attempts = 5;
        int number = 1 + (int) (100 * Math.random());

        System.out.println("Choose a number between 1-100 ");
        System.out.println("You have " + attempts + " attempts to make a correct guess ");

        for (int i = 0; i < attempts; i++) {
            System.out.print("Enter number: ");
            int guess = scanner.nextInt();
            if (guess == number) {
                System.out.println("Congratulations correct guess");
                scanner.close();
                return;
            } else if (guess > number) {
                System.out.println("Your guess: " + guess + " is greater than the number try again!");
            } else {
                System.out.println("Your guess: " + guess + " is smaller than the number try again!");
            }
        }
        System.out.println(
                "You've exhausted all attempts. The correct number was: "
                        + number);
        scanner.close();
    }


    public static void main(String[] args) {
        guessNumber();
    }
}
