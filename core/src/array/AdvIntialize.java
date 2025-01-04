package src.array;

import java.util.stream.IntStream;

public class AdvIntialize {
    public static void main(String[] args) {
        int[] arr1 = IntStream.range(1, 5).toArray();
        int[] arr2 = IntStream.rangeClosed(1, 10).toArray();
        int[] arr3 = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8).toArray();
        System.out.println("Elements added using range() :");
        for (int i : arr1)
            System.out.print(i + " ");
        System.out.println();
        System.out.println("Elements added using rangeClosed() :");
        for (int k : arr2)
            System.out.print(k + " ");
        System.out.println();
        System.out.println("Elements added using of()");
        for (int l : arr3)
            System.out.print(l + " ");

    }
}
