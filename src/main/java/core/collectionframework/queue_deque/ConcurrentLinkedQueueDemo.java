package core.collectionframework.queue_deque;


import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentLinkedQueueDemo {
    private static final ConcurrentLinkedQueue<String> taskQueue = new ConcurrentLinkedQueue<>();

    public static void main(String[] args) {

        Thread producer = new Thread(() -> {
            for (int i = 0; i < 20000; i++) {

                try {
                    taskQueue.add("Task " + System.currentTimeMillis());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        Thread consumer = new Thread(() -> {
            for (int i = 0; i < 20000; i++) {

                try {
                    String task = taskQueue.poll();
                    System.out.println("Processing: " + task);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        producer.start();
        consumer.start();


    }
}
