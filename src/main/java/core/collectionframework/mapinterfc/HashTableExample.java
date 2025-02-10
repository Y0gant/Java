package core.collectionframework.mapinterfc;

import java.util.HashMap;
import java.util.Hashtable;

public class HashTableExample {
    public static void main(String[] args) {
        Hashtable<Integer,String> students = new Hashtable<>();
        //Key And Values can't be null
        //Synchronized
        //only linked list in case of collision
        students.put(12,"Avesh");
        students.put(23,"Gautam");
        students.put(43,"Shubham");
        students.put(31,"Dev");
        students.put(21,"Anupam");
        System.out.println(students);


        // Get value by key
        System.out.println("Value for key 23: " + students.get(23));

        // Remove a key-value pair
        students.remove(21);
        System.out.println("After removing key 21: " + students);

        // Iterating over keys
        for (Integer key : students.keySet()) {
            System.out.println("Key: " + key + ", Value: " + students.get(key));
        }


        //Checking thread safety
        Hashtable<Integer, String> map = new Hashtable<>();
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                map.put(i, "Thread1");
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 1000; i < 2000; i++) {
                map.put(i, "Thread2");
            }
        });
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Final size of HashMap: " + map.size());

    }
}
