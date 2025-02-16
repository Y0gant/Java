package core.ExceptionH;

import java.util.Scanner;

public class TryCatchFinallyExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number :");
        int n = sc.nextInt();
        try {
            System.out.println(divideHundred(n));
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero :");
        } finally {
            sc.close();
        }

    }

    public static int divideHundred(int n) {
        return 100 / n;
    }
}
