package core.synchronization;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {
    private final Lock lock = new ReentrantLock();


    public static void main(String[] args) {
        ReentrantLockExample obj = new ReentrantLockExample();
        obj.outerLock();
    }

    public void outerLock() {
        lock.lock();
        try {

            System.out.println("Outer method");
            innerMethod();
        } finally {
            lock.unlock();
        }
    }

    private void innerMethod() {
        lock.lock();
        try {
            System.out.println("Inner method");
        } finally {
            lock.unlock();
        }


    }

}
