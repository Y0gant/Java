package core.synchronization;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Worker extends Thread {
    private CountDownLatch latch;

    public Worker(CountDownLatch latch) {
        this.latch = latch;
    }

    public void run() {
        System.out.println(Thread.currentThread().getName() + " is working...");
        try {
            Thread.sleep(1000); // Simulate work
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        latch.countDown(); // Decrease latch count
        System.out.println(Thread.currentThread().getName() + " finished work.");
    }
}

public class CountDownLatchExample2 {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);
        ExecutorService service = Executors.newFixedThreadPool(3);
        service.submit(new Worker(latch));
        service.submit(new Worker(latch));
        service.submit(new Worker(latch));
        
        latch.await();
        System.out.println("All workers finished. Proceeding further...");
        service.shutdown();
    }
}
