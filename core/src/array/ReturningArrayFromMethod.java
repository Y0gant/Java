package src.array;

public class ReturningArrayFromMethod {
    public static void main(String[] args) {
        int[] arr2 = array();
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }
    }

    public static int[] array() {
        return new int[]{1, 2, 3, 4, 5, 6, 7};
    }
}

