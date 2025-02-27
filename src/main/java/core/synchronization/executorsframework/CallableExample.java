package core.synchronization.executorsframework;

import java.util.concurrent.*;

public class CallableExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Callable<Integer> task = () -> {
            TimeUnit.SECONDS.sleep(2);
            return 10 + 20;
        };

        Future<Integer> result = executor.submit(task);

        System.out.println("Waiting for result...");
        System.out.println("Result: " + result.get()); // Blocks until result is available

        executor.shutdown();
    }
}

