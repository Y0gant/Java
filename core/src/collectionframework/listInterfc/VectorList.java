package src.collectionframework.listInterfc;

import java.util.ArrayList;
import java.util.Vector;

public class VectorList {
    public static void main(String[] args) {
        Vector<Integer> vector = new Vector<>(10, 5);
        System.out.println("Is vector empty :" + vector.isEmpty());
        vector.add(1);
        vector.add(2);
        vector.add(3);
        vector.add(4);
        vector.add(6);
        vector.add(7);
        vector.add(8);
        System.out.println("Current capacity :" + vector.capacity());
        System.out.println(vector);
        System.out.println("Current size :" + vector.size());
        vector.add(4, 5);
        System.out.println(vector);
        System.out.println("Element at index 4 :" + vector.get(4));
        vector.setSize(11);
        System.out.println("Current size :" + vector.size());
        System.out.println("Current capacity :" + vector.capacity());
        System.out.println(vector);
        vector.remove(3);
        vector.remove(Integer.valueOf(7));
        vector.set(4, 12);
        System.out.println(vector);
        System.out.println("Current size :" + vector.size());
        vector.clear();
        System.out.println("Is vector empty :" + vector.isEmpty());
        System.out.println("Current capacity :" + vector.capacity());
        ArrayList<Integer> arr = new ArrayList<>();
        Thread t1 = new Thread(() ->
        {
            for (int i = 0; i < 500; i++) {
                arr.add(i);
            }
        });

        Thread t2 = new Thread(() ->
        {
            for (int i = 0; i < 500; i++) {
                arr.add(i);
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Expected size of ArrayList : 1000");
        System.out.println("Actual size of ArrayList :" + arr.size());
        System.out.println("ArrayList != thread safe");


        Vector<Integer> vecr = new Vector<>();
        Thread t3 = new Thread(() ->
        {
            for (int i = 0; i < 500; i++) {
                vecr.add(i);
            }
        });

        Thread t4 = new Thread(() ->
        {
            for (int i = 0; i < 500; i++) {
                vecr.add(i);
            }
        });

        t3.start();
        t4.start();

        try {
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Expected size of Vector : 1000");
        System.out.println("Actual size of Vector :" + vecr.size());
        System.out.println("Vector == thread safe");


    }
}
