package core.collectionframework.mapinterfc;

import java.util.concurrent.ConcurrentSkipListMap;

public class ConcurrentSkipListMapExample {

    public static void main(String[] args) {
        // Creating a ConcurrentSkipListMap
        ConcurrentSkipListMap<Integer, String> skipListMap = new ConcurrentSkipListMap<>();

        // Adding elements
        skipListMap.put(3, "Charlie");
        skipListMap.put(1, "Alice");
        skipListMap.put(2, "Bob");
        skipListMap.put(5, "Eve");
        skipListMap.put(4, "David");

        // Printing elements (Sorted Order)
        System.out.println("ConcurrentSkipListMap: " + skipListMap);
        // Output: {1=Alice, 2=Bob, 3=Charlie, 4=David, 5=Eve}

        // Accessing elements
        System.out.println("First Entry: " + skipListMap.firstEntry()); // {1=Alice}
        System.out.println("Last Entry: " + skipListMap.lastEntry()); // {5=Eve}

        // Removing elements
        skipListMap.remove(3);
        System.out.println("After removing key 3: " + skipListMap);

        // Iterating using for-each loop
        for (Integer key : skipListMap.keySet()) {
            System.out.println("Key: " + key + ", Value: " + skipListMap.get(key));
        }
    }
}


