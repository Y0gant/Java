package core.multi_threading;

class AnotherThread extends Thread {
    @Override
    public void run() {
        long st = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " By extending Thread class.");
        }
        long et = System.nanoTime();
        System.out.println("Time required for " + Thread.currentThread().getName() + " :" + (et - st) + " nano-secs");
    }
}

class RunnableThread implements Runnable {
    @Override
    public void run() {
        long st = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " By implementing Runnable Interface.");
        }
        long et = System.nanoTime();
        System.out.println("Time required for " + Thread.currentThread().getName() + " :" + (et - st) + " nano-secs");
    }
}


public class MultiThreadingExample1 {
    public static void main(String[] args) {
        long st = System.nanoTime();

        AnotherThread obj = new AnotherThread();
        // Can directly use the start method as we are extending
        // the Thread class.
        obj.start();

        // This class implements the runnable interface
        // which does not have start method
        RunnableThread obj2 = new RunnableThread();
        // to use start method and start thread we need to create an object of
        // thread class and pass the object of the
        // class implementing Runnable interface.
        Thread t1 = new Thread(obj2);
        t1.start();

        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName());
        }
        long et = System.nanoTime();
        System.out.println("Time required for main thread :" + (et - st) + " nano-secs");
    }
}
