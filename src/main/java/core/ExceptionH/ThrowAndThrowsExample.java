package core.ExceptionH;

import java.util.Scanner;

public class ThrowAndThrowsExample {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int age = sc.nextInt();
            validateAge(age);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void validateAge(int age) throws IllegalArgumentException {
        if (age < 18) {
            throw new IllegalArgumentException("Not Valid");
        } else {
            System.out.println("This Person is Eligible to vote");
        }
    }
}
