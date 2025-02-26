package core.synchronization;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


class FairLock {
    private final Lock fairLock = new ReentrantLock(true);

    public void accessResource() {
        fairLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " acquired the lock.");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Thread Interrupted");
            Thread.currentThread().interrupt();
        } finally {
            System.out.println(Thread.currentThread().getName() + " released the lock.");
            fairLock.unlock();
        }
    }
}

@SuppressWarnings("All")
public class FairLockExample {
    public static void main(String[] args) throws InterruptedException {

        FairLock fairLock = new FairLock();
        Runnable task2 = new Runnable() {
            @Override
            public void run() {
                fairLock.accessResource();
            }
        };


        Thread ft1 = new Thread(task2, "Thread1");
        Thread ft2 = new Thread(task2, "Thread2");
        Thread ft3 = new Thread(task2, "Thread3");
        Thread ft4 = new Thread(task2, "Thread4");

        ft1.start();
        ft2.start();
        ft3.start();
        ft4.start();
        ft1.join();
        ft2.join();
        ft3.join();
        ft4.join();
    }
}
