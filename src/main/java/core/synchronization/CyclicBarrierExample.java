package core.synchronization;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {
    public static void main(String[] args) {
        int initializationTime = 4;
        CyclicBarrier barrier = new CyclicBarrier(initializationTime, () -> System.out.println("All subsystems are up and running. System startup complete."));

        Thread webServerThread = new Thread(new SubSystem("Web Server", 2000, barrier));
        Thread databaseThread = new Thread(new SubSystem("Database", 4000, barrier));
        Thread cacheThread = new Thread(new SubSystem("Cache", 3000, barrier));
        Thread messagingServiceThread = new Thread(new SubSystem("Messaging Service", 3500, barrier));

        webServerThread.start();
        databaseThread.start();
        cacheThread.start();
        messagingServiceThread.start();

    }
}

class SubSystem implements Runnable {

    private final String name;
    private final CyclicBarrier barrier;
    private final int initializationTime;

    public SubSystem(String name, int initializationTime, CyclicBarrier barrier) {
        this.barrier = barrier;
        this.initializationTime = initializationTime;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " initialization started.");
            Thread.sleep(initializationTime);
            System.out.println(name + " initialization complete.");
            barrier.await();

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (BrokenBarrierException e) {
            System.out.println("Error " + e.getLocalizedMessage());
        }
    }
}