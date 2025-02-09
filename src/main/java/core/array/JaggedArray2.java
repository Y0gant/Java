package core.array;

/**
 * Program for creating a jagged array
 * where with each count size of
 * sub array increments
 */
public class JaggedArray2 {
    public static void main(String[] args) {
        int[][] arr1 = new int[5][];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = new int[i + 1];
        }
        //initializing values
        int count = 1;
        for (int j = 0; j < arr1.length; j++) {
            for (int l = 0; l < arr1[j].length; l++) {
                arr1[j][l] = count;
                count++;
            }
        }
        //printing values
        for (int k = 0; k < arr1.length; k++) {
            for (int p = 0; p < arr1[k].length; p++) {
                System.out.print(arr1[k][p] + " ");
            }
            System.out.println();
        }
    }
}
