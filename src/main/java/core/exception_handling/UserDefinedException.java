package core.exception_handling;

import java.util.Scanner;

public class UserDefinedException {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try (sc) {
            int marks = sc.nextInt();
            getPercentage(marks);
        } catch (InvalidMarksException o) {
            System.out.println(o.getMessage());
        }
    }

    public static void getPercentage(int marks) {
        if (marks < 0 || marks > 100) {
            throw new InvalidMarksException("Enter Valid Marks!!");
        } else {
            System.out.println("Percentage :" + (marks / 100) * 100 + "%");
        }

    }
}
