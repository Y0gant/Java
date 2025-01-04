package src.array;

public class CloningArray {
    public static void main(String[] args) {


        int[] arr1 = {1, 2, 3, 4, 5, 6};
        int[][] arr2 = {{1, 2, 3}, {4, 5, 6}};
        int[] copyArr = arr1.clone();
        int[][] copyArr2 = arr2.clone();
        System.out.println(arr1 == copyArr);
        System.out.println(arr1[0] == copyArr[0]);
        System.out.println(arr2 == copyArr2);
        // true as sub arrays are shared
        System.out.println(arr2[0] == copyArr2[0]);

    }
}