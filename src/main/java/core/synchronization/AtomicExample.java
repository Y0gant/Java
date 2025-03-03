package core.synchronization;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicExample {
    private final AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        AtomicExample obj = new AtomicExample();

        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 1000; i++) {
                obj.incrementCounter();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 1; i <= 1000; i++) {
                obj.incrementCounter();
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(obj.getCounter());

    }

    public int getCounter() {
        return counter.get();
    }

    public void incrementCounter() {
        counter.incrementAndGet();
    }
}
