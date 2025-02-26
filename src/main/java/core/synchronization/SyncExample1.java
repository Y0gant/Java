package core.synchronization;

class Counter {
    private int count = 0;

    public void nonSyncIncrement() {
        count++;
    }

    public synchronized void increment() {
        /*
        Can also use synchronized block
        synchronized(this){
        count++
        }
         */

        count++;
    }

    public int getCount() {
        return count;
    }
}

class MyThread extends Thread {

    private final Counter counter;

    public MyThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            counter.increment();
        }
    }
}

public class SyncExample1 {

    public static void main(String[] args) {

        // Demonstrating non-synchronized method
        Counter counter2 = new Counter();
        Thread nt1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                counter2.nonSyncIncrement();
            }
        });

        Thread nt2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                counter2.nonSyncIncrement();
            }
        });
        nt1.start();
        nt2.start();

        try {
            nt1.join();
            nt2.join();
        } catch (InterruptedException e) {
            System.out.println("Error: " + e);
        }
        System.out.println("Expected count (non-synchronized) = 20000 ");
        System.out.println("Actual count (non-synchronized) = " + counter2.getCount());


        // Demonstrating synchronized method
        Counter counter1 = new Counter();
        MyThread t1 = new MyThread(counter1);
        MyThread t2 = new MyThread(counter1);
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Error: " + e);
        }
        System.out.println("Expected count (synchronized) = 20000 ");
        System.out.println("Actual count (synchronized) = " + counter1.getCount());


    }
}
