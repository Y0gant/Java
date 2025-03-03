package core.collectionframework.mapinterfc;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {
    // Java 7 --> segment based locking --> 16 segments --> smaller hashmaps
    // Only the segment being written to or read from is locked
    // read: do not require locking unless there is a write operation happening on the same segment
    // write: lock

    // java 8 --> no segmentation
    //        --> Compare-And-Swap approach --> no locking except resizing or collision
    // Thread A last saw --> x = 45
    // Thread A work --> x to 50
    // if x is still 45, then change it to 50 else don't change and retry
    // put --> index

    // MAP --> SORTED --> THREAD SAFE --> ConcurrentSkipListMap


    public static void main(String[] args) {
        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();

        map.put(1, "Apple");
        map.put(2, "Banana");

        System.out.println(map.get(1)); // Apple

        // Atomic update
        map.putIfAbsent(2, "Cherry");
        System.out.println(map.get(2)); // Banana (not updated because key 2 exists)
    }
}

