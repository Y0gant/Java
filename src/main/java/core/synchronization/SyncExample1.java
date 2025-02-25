package core.synchronization;

class Counter {
    private int count = 0;
    private int count2 = 0;

    public int getCount2() {
        return count2;
    }


    public void incrementCount2() {
        count2++;
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

    private Counter counter;

    public MyThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.incrementCount2();
            counter.increment();
        }
    }
}

public class SyncExample1 {

    public static void main(String[] args) {

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
        System.out.println("Expected count (synchronized) = 2000 ");
        System.out.println("Real count (synchronized) = " + counter1.getCount());

        // Demonstrating non-synchronized method
        Counter counter2 = new Counter();
        MyThread nt1 = new MyThread(counter2);
        MyThread nt2 = new MyThread(counter2);
        nt1.start();
        nt2.start();

        try {
            nt1.join();
            nt2.join();
        } catch (InterruptedException e) {
            System.out.println("Error: " + e);
        }
        System.out.println("Expected count (non-synchronized) = 2000 (Result may vary)");
        System.out.println("Real count (non-synchronized) = " + counter2.getCount2());
    }
}
