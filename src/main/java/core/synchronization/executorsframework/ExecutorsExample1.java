package core.synchronization.executorsframework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class ExecutorsExample1 {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        //manual thread creation using array of thread
        //multiple threads
        //no thread reuse
        //resource wastage
        System.out.println("Factorial of first 10 natural" + " numbers without using executors framework");
        Thread[] threads = new Thread[10];
        for (int i = 1; i <= 10; i++) {
            int fin = i;
            threads[i - 1] = new Thread(() -> {
                long result = factorial(fin);
                System.out.println("Factorial of " + fin + " is :" + result);
            });
            threads[i - 1].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println("Error...");
            }
        }
        System.out.println("Time taken :" + (System.currentTimeMillis() - startTime) + " ms");

        //using executors framework
        System.out.println("Factorial of first 10 natural" + " numbers using executors framework");
        long startTime2 = System.currentTimeMillis();
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= 10; i++) {
            int fin = i;
            executor.submit(() -> {
                long result = factorial(fin);
                System.out.println("Factorial of " + fin + " is :" + result);
            });
        }
        executor.shutdown();
        try {
            boolean executedInTime = executor.awaitTermination(5, TimeUnit.SECONDS);
            System.out.println("Completed task in given timeout ->" + executedInTime);
        } catch (InterruptedException e) {
            System.out.println("Error");
        }
        System.out.println("Time taken :" + (System.currentTimeMillis() - startTime2) + " ms");
    }

    public static long factorial(int i) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long result = 1;
        for (int j = 1; j <= i; j++) {
            result *= j;
        }
        return result;
    }
}