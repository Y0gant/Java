package src.methods;

import java.util.Scanner;

//Simple code that uses a method to perform addition operation on
// two user input integer variables
public class Methd {
    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in);
        Methd Mt = new Methd();
        int s = Mt.Addition(Sc.nextInt(), Sc.nextInt());
        System.out.println(s);
    }

    int Addition(int a, int b) {
        return a + b;
    }
}
