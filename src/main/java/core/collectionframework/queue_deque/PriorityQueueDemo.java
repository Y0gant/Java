package core.collectionframework.queue_deque;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueDemo {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue1 = new PriorityQueue<>();
        queue1.add(10);
        queue1.add(24);
        queue1.add(5);
        queue1.add(11);
        queue1.add(16);
        System.out.println(queue1);
        System.out.println("Get first element :" + queue1.peek());
        System.out.println("Removed element :" + queue1.poll());
        System.out.println(queue1);
        System.out.println("Removed element :" + queue1.poll());
        System.out.println(queue1);
        System.out.println("Removed element :" + queue1.poll());
        System.out.println(queue1);
        System.out.println("Removed element :" + queue1.poll());
        queue1.add(10);
        queue1.add(24);
        queue1.add(5);
        queue1.add(11);
        queue1.add(16);
        queue1.add(61);
        queue1.add(41);
        queue1.add(36);
        System.out.println(queue1);
        while (!queue1.isEmpty()) {
            System.out.print(queue1.poll() + ",");
        }
        System.out.println();
        System.out.println("Current size of queue :" + queue1.size());


        PriorityQueue<Integer> queue2 = new PriorityQueue<>(Comparator.reverseOrder());
        //Natural ordering will be reversed.
        queue2.add(13);
        queue2.add(78);
        queue2.add(31);
        queue2.add(54);
        queue2.add(32);
        queue2.add(11);
        queue2.add(93);
        queue2.add(1);
        queue2.add(21);
        queue2.add(3);
        queue2.add(67);
        queue2.add(13);
        queue2.add(63);
        System.out.println(queue2);
        while (!queue2.isEmpty()) {
            System.out.println("Removed Element :" + queue2.poll());

        }


    }
}
