package core.collectionframework.mapinterfc;
import java.util.*;

public class TreeMapExample {
    public static void main(String[] args) {
        SortedMap<Integer, String> sortedMap = new TreeMap<>();

        sortedMap.put(3, "Alice");
        sortedMap.put(1, "Bob");
        sortedMap.put(2, "Charlie");
        sortedMap.put(5, "Eve");
        sortedMap.put(4, "David");

        System.out.println("SortedMap: " + sortedMap);
        System.out.println("First Key: " + sortedMap.firstKey()); // 1
        System.out.println("Last Key: " + sortedMap.lastKey()); // 5
        System.out.println("Head Map (before 3): " + sortedMap.headMap(3));
        System.out.println("Tail Map (from 3): " + sortedMap.tailMap(3));
        System.out.println("Sub Map (2 to 4): " + sortedMap.subMap(2, 4));


        NavigableMap<Integer, String> navMap = new TreeMap<>();
        navMap.put(10, "Ten");
        navMap.put(20, "Twenty");
        navMap.put(30, "Thirty");

        System.out.println(navMap.lowerKey(25));   // (just below 25)
        System.out.println(navMap.higherKey(25));  // (just above 25)
        System.out.println(navMap.floorKey(20));   // (≤ given key)
        System.out.println(navMap.ceilingKey(25)); // (≥ given key)
        System.out.println(navMap.descendingMap()); // Reverse order
    }
}

