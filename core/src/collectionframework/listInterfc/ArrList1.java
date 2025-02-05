package src.collectionframework.listInterfc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrList1 {
    public static void main(String[] args) {
        List<String> str = new ArrayList<>();
        List<Integer> arr = new ArrayList<>(12);
        //Add elements
        str.add("Alpha");
        str.add("Beta");
        str.add("Gamma");
        str.add("Epsilon");
        str.add("Eta");
        System.out.println("Initial List of string :" + str);
        str.add(3, "Delta");//Add element in between
        str.set(5, "Zeta");//Relpace element
        System.out.println("Updated lisr :" + str);
        System.out.println("At index 3 :" + str.get(3));//get value at given index number
        System.out.println("Index of Epsilon :" + str.indexOf("Epsilon"));//get index of object

        List<Integer> arr2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 11);//add collection of elements
        List<Integer> arr3 = List.of(8, 9, 10);

        arr.addAll(arr2);
        for (int l : arr) System.out.print(":" + l);
        System.out.println();
        System.out.println("Initial list of array :" + arr);

        arr.addAll(7, arr3);// add collection at specific location
        arr.addAll(List.of(12, 13, 14, 15, 16, 17, 18));
        System.out.println("Updated array :" + arr);

        arr.removeAll(arr3);//remove collection of elements
        arr.remove(Integer.valueOf(12));//remove specific value of integer
        System.out.println(arr);
        arr.removeIf(i -> i % 2 != 0);//remove if given condition is true
        System.out.println(arr);
        arr.retainAll(Arrays.asList(2, 4, 6, 14, 18));//retain only geven collection
        System.out.println(arr);

        System.out.println("Is 14 present :" + arr.contains(14));// return true if element present
        System.out.println("Is 12 present :" + arr.contains(12));
        System.out.println("Contain given elements :" + arr.containsAll(Arrays.asList(2, 4, 6)));//return true if all collection of elements present

        Object[] arr5 = arr.toArray();//convert arraylist to array
        for (Object k : arr5) System.out.print(k + " ");
        System.out.println();

        System.out.println("Is arr empty?");
        System.out.println(": " + arr.isEmpty());//check if list is empty
        arr.clear();//clear all element (delete)
        System.out.println("Now?");
        System.out.println(": " + arr.isEmpty());


    }
}
