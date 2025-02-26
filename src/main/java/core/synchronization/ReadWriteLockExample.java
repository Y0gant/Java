package core.synchronization;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockExample {
    private final ReadWriteLock locker = new ReentrantReadWriteLock();
    private final Lock readLock = locker.readLock();
    private final Lock writeLock = locker.writeLock();
    private int count;

    public static void main(String[] args) throws InterruptedException {
        ReadWriteLockExample readWriteLockExample = new ReadWriteLockExample();

        Runnable readTask = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " read: " + readWriteLockExample.getCount());
            }
        };


        Runnable writeTask = () -> {
            for (int i = 0; i < 10; i++) {
                readWriteLockExample.increment();
                System.out.println(Thread.currentThread().getName() + " incremented");
            }
        };

        Thread writerThread = new Thread(writeTask);
        Thread readerThread1 = new Thread(readTask);
        Thread readerThread2 = new Thread(readTask);

        writerThread.start();
        readerThread1.start();
        readerThread2.start();

        writerThread.join();
        readerThread1.join();
        readerThread2.join();

        System.out.println("Final count: " + readWriteLockExample.getCount());

    }

    public void increment() {
        writeLock.lock();
        try {
            count++;
            Thread.sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            writeLock.unlock();
        }
    }

    public int getCount() {
        readLock.lock();
        try {
            return count;
        } finally {
            readLock.unlock();
        }
    }

}