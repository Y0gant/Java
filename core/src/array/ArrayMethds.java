package src.array;

import java.util.Arrays;
import java.util.List;


public class ArrayMethds {
    public static void main(String[] args) {


        System.out.println("array to list");
        int[] arr2 = {1, 2, 3};
        List<int[]> list = List.of(arr2);
        System.out.println(list);

        System.out.println("binary search without range");
        int[] arr = {1, 3, 5, 7, 9};
        int index = Arrays.binarySearch(arr, 5);
        System.out.println(index);

        System.out.println("binary search with range");
        int index2 = Arrays.binarySearch(arr, 1, 4, 5);
        System.out.println(index2);


        System.out.println("compares values inside an array");
        int[] arr11 = {1, 2, 3};
        int[] arr12 = {1, 2, 4};
        int result = Arrays.compare(arr11, arr12);
        System.out.println(result);

        System.out.println("create deep copy of an array");
        int[] arr4 = {1, 2, 3};
        int[] newArr = Arrays.copyOf(arr4, 5);
        System.out.println(Arrays.toString(newArr));

        System.out.println("copy of array from range a to b");
        int[] arr5 = {1, 2, 3, 4, 5};
        int[] subArray = Arrays.copyOfRange(arr5, 1, 4);
        System.out.println(Arrays.toString(subArray));

        System.out.println("Checks if two arrays (including nested arrays) are deeply equal.");
        Integer[][] arr7 = {{1, 2}, {3, 4}};
        Integer[][] arr8 = {{1, 2}, {3, 4}};
        System.out.println(Arrays.deepEquals(arr7, arr8));

        System.out.println("hashcode for multi dimension array");
        Integer[][] arrh = {{1, 2}, {3, 4}};
        System.out.println(Arrays.deepHashCode(arrh));

        System.out.println("String representation of nested array");
        Integer[][] arr9 = {{1, 2}, {3, 4}};
        System.out.println(Arrays.deepToString(arr9));

        System.out.println("check if array are equal or not");
        int[] aarr1 = {1, 2, 3};
        int[] aarr2 = {1, 2, 3};
        System.out.println(Arrays.equals(aarr1, aarr2));

        System.out.println("fill array with specific value");
        int[] fil = new int[5];
        Arrays.fill(arr, 9);
        System.out.println(Arrays.toString(fil));

        System.out.println("hash code of array");
        int[] hsh = {1, 2, 3};
        System.out.println(Arrays.hashCode(hsh));

        System.out.println("find and return first mismatch element index");
        int[] mis1 = {1, 2, 3};
        int[] mis2 = {1, 4, 3};
        System.out.println(Arrays.mismatch(mis1, mis2));

        System.out.println("sort array in parallel");
        int[] par = {5, 3, 8, 1};
        Arrays.parallelSort(arr);
        System.out.println(Arrays.toString(par));

        System.out.println("set values of array based on some generator function");
        int[] st = new int[5];
        Arrays.setAll(st, i -> i * i);
        System.out.println(Arrays.toString(arr));

        System.out.println("sort array in ascending order");
        int[] srt = {5, 3, 8, 1};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(srt));


        System.out.println("array to stream");
        int[] str = {1, 2, 3};
        Arrays.stream(str).forEach(System.out::print);
        System.out.println();
        System.out.println("array to string");
        int[] stn = {1, 2, 3};
        System.out.println(Arrays.toString(stn));

    }
}
