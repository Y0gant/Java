package core.multi_threading;


class CreateThread1 extends Thread {
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

class CreateThread2 implements Runnable {
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

        CreateThread1 thread1 = new CreateThread1();
        // Can directly use the start method as we are extending
        // the Thread class.
        thread1.start();

        // This class implements the runnable interface
        // which does not have start method
        CreateThread2 thread2 = new CreateThread2();
        // to use start method and start thread we need to create an object of
        // thread class and pass the object of the
        // class implementing Runnable interface.
        Thread threadObj = new Thread(thread2);
        threadObj.start();

        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName());
        }
        long et = System.nanoTime();
        System.out.println("Time required for main thread :" + (et - st) + " nano-secs");
    }
}
