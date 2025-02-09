package core.array;

import java.util.Scanner;

/**
 * This program demonstrate use of scanner class to get
 * user to initialize a jagged array and initialize values
 * using user input and display those values
 */
public class JaggedArray3 {
    public static void main(String[] args) {
        JaggedArray3 obj = new JaggedArray3();
        int[][] myarray = obj.InitializeArray();
        obj.SetValues(myarray);
        obj.PrintValues(myarray);
    }

    //Initializer method to initialize a jagged array
    public int[][] InitializeArray() {
        Scanner Scn = new Scanner(System.in);
        System.out.print("Enter No. of Rows :");
        int rows = Scn.nextInt();
        int[][] jArr = new int[rows][];
        System.out.println();
        for (int i = 0; i < rows; i++) {
            System.out.print("Enter no. of Columns in row " + (i + 1) + ":");
            int columns = Scn.nextInt();
            jArr[i] = new int[columns];
            System.out.println();
        }
        return jArr;
    }

    //Setter method for setting values in array
    public void SetValues(int[][] arr1) {
        Scanner Scn2 = new Scanner(System.in);
        for (int p = 0; p < arr1.length; p++) {
            for (int o = 0; o < arr1[p].length; o++) {
                System.out.println("Enter value for element in row :" + (p + 1) + " column :" + (o + 1) + " :");
                arr1[p][o] = Scn2.nextInt();
            }
        }
    }

    //Print method to print values of array
    public void PrintValues(int[][] arr) {
        System.out.println("Elements of jagged array are :");
        for (int w = 0; w < arr.length; w++) {
            for (int q = 0; q < arr[w].length; q++) {
                System.out.print(arr[w][q] + " ");
            }
            System.out.println();
        }
    }
}
