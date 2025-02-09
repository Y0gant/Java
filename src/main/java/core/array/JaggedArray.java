package core.array;

/**
 * This program contains
 * declaration of jagged array *types
 * initialization *types
 * printing *types
 */
public class JaggedArray {
    public static void main(String[] args) {
//Declaring a jagged array
        int[][] jArr1 = new int[3][];
        jArr1[0] = new int[5];
        jArr1[1] = new int[4];
        jArr1[2] = new int[3];
        int[] arr = {26, 26, 78, 45, 89, 16, 86, 18, 12, 10, 34, 56};
        //Assigning values to jagged array using for loop
        int count = 0;
        for (int i = 0; i < jArr1.length; i++) {
            for (int j = 0; j < jArr1[i].length; j++) {
                jArr1[i][j] = arr[count];
                count++;
            }
        }
        //printing values inside jagged array using for loop
        System.out.println("Values initialized using for loop in jagged array:");
        for (int k = 0; k < jArr1.length; k++) {
            for (int l = 0; l < jArr1[k].length; l++) {
                System.out.print(jArr1[k][l] + " ");
            }
            System.out.println(" ");
        }

        //Normal initialization types
        //type1
        int[][] jArr2 = new int[][]{
                new int[]{1, 2, 3},
                new int[]{1, 2},
                new int[]{1, 2, 3, 4, 5}
        };
        //type 2
        int[][] jArr3 = new int[][]{
                {10, 20, 30},
                {10, 20},
                {10, 20, 30, 40, 50}
        };
        int[][] jArr4 = {
                {100, 200, 300},
                {100, 200},
                {100, 200, 300, 400, 500}
        };


    }
}
