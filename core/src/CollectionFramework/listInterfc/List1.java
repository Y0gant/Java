package src.CollectionFramework.listInterfc;

import java.util.ArrayList;
import java.util.List;

/**
 * This program contains a simplle implementation of list interface
 * and some methods related to list/collection interface.
 */
public class List1 {
    public static void main(String[] args) {
        //Creating an object of List(ArrayList) of type string.
        List<String> li = new ArrayList<>();
        li.add(0, "Java");
        li.add(1, "C++");
        li.add(2, "C");
        li.add(3, "C#");
        li.add(4, "Python");
        li.add(5, "Go");
        System.out.println("Elements of List are :");
        for (String i : li) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("Element at index 1 is :" + li.get(1));

        li.set(2, "Rust");
        System.out.println("Updated list :" + li);

        li.remove("Python");
        System.out.println("List after removing element :" + li);

    }
}
