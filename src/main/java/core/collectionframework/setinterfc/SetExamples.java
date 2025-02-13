package core.collectionframework.setinterfc;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetExamples {
    public static void main(String[] args) {
        // 1. HashSet Example
        Set<String> hashSet = new HashSet<>();
        hashSet.add("Apple");
        hashSet.add("Banana");
        hashSet.add("Cherry");
        hashSet.add("Banana"); //  ignored
        System.out.println("HashSet: " + hashSet);

        // Methods of HashSet
        System.out.println("Contains Apple? " + hashSet.contains("Apple"));
        hashSet.remove("Banana");
        System.out.println("After removal: " + hashSet);
        System.out.println("HashSet size: " + hashSet.size());

        // 2. LinkedHashSet Example
        Set<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("Dog");
        linkedHashSet.add("Elephant");
        linkedHashSet.add("Cat");
        System.out.println("\nLinkedHashSet: " + linkedHashSet);

        // 3. TreeSet Example (Sorted)
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(50);
        treeSet.add(10);
        treeSet.add(30);
        treeSet.add(40);
        System.out.println("\nTreeSet (Sorted): " + treeSet);

        // Methods Specific to TreeSet
        System.out.println("First Element: " + treeSet.first());
        System.out.println("Last Element: " + treeSet.last());
        System.out.println("Higher than 30: " + treeSet.higher(30));
        System.out.println("Lower than 30: " + treeSet.lower(30));

        // Common Methods
        System.out.println("\nIterating over HashSet:");
        for (String fruit : hashSet) {
            System.out.println(fruit);
        }

        hashSet.clear();
        System.out.println("Is HashSet empty? " + hashSet.isEmpty());
    }
}
