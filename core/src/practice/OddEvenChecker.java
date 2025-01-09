package src.practice;

import java.util.Scanner;

public class OddEvenChecker {
    public static void main(String[] args) {
        OddEvenChecker Obj1 = new OddEvenChecker();
        Obj1.getInput();

    }

    public void getInput() {
        Scanner scn2 = new Scanner(System.in);
        System.out.println("Enter Numbers :");
        String input = scn2.nextLine();
        String[] Numbers = input.split(" ");
        System.out.println("Input is :" + input);
        convertToArray(Numbers);

    }

    public void convertToArray(String[] Numbers) {
        int[] arr = new int[Numbers.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(Numbers[i]);
        }

        OddEven(arr);
    }

    public void OddEven(int... a) {
        int even = 0;
        int odd = 0;
        int evensum = 0;
        int oddsum = 0;
        for (int k : a) {
            if (k % 2 == 0) {
                System.out.print(k + " is:Even ");
                even++;
                evensum += k;
            } else {
                System.out.print(k + " is:Odd ");
                odd++;
                oddsum += k;
            }
        }
        System.out.println();
        System.out.println("Number of Even numbers is :" + even + " and their sum is :" + evensum);
        System.out.println("Number of Odd numbers is :" + odd + " and their sum is :" + oddsum);
    }

}