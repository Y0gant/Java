package core.collectionframework.mapinterfc;

import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashMapDemo {
    public static void main(String[] args) {
        WeakHashMap<String, String> cacheValue = new WeakHashMap<>();
        loadCache(cacheValue);
        System.out.println("Before Garbage Collector invoked :" + cacheValue);
        System.gc();//Suggest/Request JVM to Run Garbage Collector
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }

        System.out.println("After Garbage collector(some entries may get cleared) :" + cacheValue);
    }

    public static void loadCache(Map<String, String> cacheValue) {
        String s1 = new String("A");
        String s2 = new String("B");
        String s3 = new String("C");
        String s4 = new String("D");

        /* Referenced using an object so that the reference
         * gets deleted as a string automatically gets strong referenced
         * due to it being stored inside the string pool  */
        cacheValue.put(s1, "Alabasta");
        cacheValue.put(s2, "Skypiea");
        cacheValue.put(s3, "Enies Lobby");
        cacheValue.put(s4, "Water7");
    }
}
