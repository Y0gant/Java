package core.multi_threading;

import org.jetbrains.annotations.NotNull;

class ThreadMethodsExample extends Thread {
    @Override
    public void run() {
        System.out.println("Thread is running.....");
        for (int i = 1; i <= 5; i++) {
            System.out.println(i + " ");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Error occurred.." + e.getMessage());
                e.printStackTrace();
            }
        }
        try {
            System.out.println("\nSleep for 5 sec");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("Error occurred.." + e.getMessage());
            e.printStackTrace();
        }
    }
}

class PriorityChecker extends Thread {
    public PriorityChecker(@NotNull String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " Priority = " + Thread.currentThread().getPriority());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class YieldCheck extends Thread {
    public YieldCheck(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Error ..");
            }
            System.out.println(Thread.currentThread().getName() + " is running ...");
            Thread.yield();
        }
    }
}

@SuppressWarnings("all")
class DaemonThreadExample extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println("Daemon thread is running...");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Daemon thread interrupted.");
            }
        }
    }
}

public class ThreadMethods extends Thread {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("start(), run(), join() method example");

        ThreadMethodsExample t1 = new ThreadMethodsExample();
        t1.start(); // Start new thread
        System.out.println("Is thread still alive ?" + t1.isAlive());
        t1.join(); // Wait for current thread to finish
        System.out.println("Is thread still alive ?" + t1.isAlive());
        System.out.println("Continuation of main thread after the previous thread is finished..");

        PriorityChecker highPriority = new PriorityChecker("Thread 1");
        PriorityChecker normPriority = new PriorityChecker("Thread 2");
        PriorityChecker lowPriority = new PriorityChecker("Thread 3");

        System.out.println("setPriority() and getPriority() method example");

        highPriority.setPriority(Thread.MAX_PRIORITY);
        normPriority.setPriority(Thread.NORM_PRIORITY);
        lowPriority.setPriority(Thread.MIN_PRIORITY);

        highPriority.start();
        normPriority.start();
        lowPriority.start();

        highPriority.join();
        normPriority.join();
        lowPriority.join();

        System.out.println("interrupt() method example");
        ThreadMethodsExample interrupt1 = new ThreadMethodsExample();
        interrupt1.start();
        interrupt1.interrupt();
        interrupt1.join();


        YieldCheck yieldCheck1 = new YieldCheck("Thread1");
        YieldCheck yieldCheck2 = new YieldCheck("Thread2");
        System.out.println("yield() method example");
        yieldCheck1.start();
        yieldCheck2.start();


        System.out.println("Daemon thread example using setDaemon() method");
        DaemonThreadExample daemonThread = new DaemonThreadExample();
        daemonThread.setDaemon(true);
        daemonThread.start();

        Thread.sleep(5000);
        System.out.println("Main thread finished. Daemon thread will also stop.");
    }
}
