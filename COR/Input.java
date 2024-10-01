

import java.util.Scanner;
public class Input {
    /*program to get user input and perform operations on those*/
public static void main(String[] args) {
    System.out.println("Taking user input :");
    try (Scanner Sc = new Scanner(System.in)) {
        System.out.println("Enter no. 1 :");
        int a =Sc.nextInt(); 
        System.out.println("Enter no. 2 :");
        int b =Sc.nextInt();
        int sum = a+b ; 
        System.out.println("sum of " +a+ " & " +b+ " is : " +sum);
        boolean c =Sc.hasNextDouble();
        System.out.println(c);
    }
}
}
