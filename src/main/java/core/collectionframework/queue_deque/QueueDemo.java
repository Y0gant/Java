package core.collectionframework.queue_deque;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class QueueDemo {
    public static void main(String[] args) {
        Queue<Integer> queue1 = new LinkedList<>();
        queue1.add(10);
        queue1.add(12);
        queue1.add(14);
        System.out.println(queue1);
        System.out.println("Size :" + queue1.size());
        System.out.println("Current first element :" + queue1.element());
        System.out.println(queue1.remove());
        System.out.println(queue1.remove());

        System.out.println(queue1.remove());
        // System.out.println(queue1.remove()); //throws Exception
        System.out.println("Removed Element :" + queue1.poll());// returns null
        //System.out.println("Current first element :" + queue1.element()); //throws exception
        System.out.println("Current first element :" + queue1.peek());

        Queue<Integer> queue2 = new ArrayBlockingQueue<>(2);
        System.out.println(queue2.add(10));
        System.out.println(queue2.offer(20));
        //System.out.println(queue2.add(10)); throws exception
        System.out.println(queue2.offer(200));
        System.out.println(queue2);


    }
}
