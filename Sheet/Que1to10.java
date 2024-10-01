import java.util.Scanner;

public class Que1to10 {
public static void main(String[] args) {
    Scanner Sc = new Scanner(System.in);
    System.out.println("enter a number :");
    int A = Sc.nextInt();
    if (A % 2 ==0) {
        System.out.println(A +" is a Even Number");
    } else {
        System.out.println(A +" is a Odd Number");
    }
    Sc.close();
}

}
