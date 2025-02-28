package core.synchronization;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000); // Simulate a long-running task
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Hello, CompletableFuture!";
        });

        System.out.println("Doing something else while the future runs...");

        // Blocking call - waits for result
        String result = future.get();
        System.out.println("Result: " + result);

        CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> System.out.println("Running a task asynchronously..."));
        future2.get();

        CompletableFuture<Integer> future3 = CompletableFuture.supplyAsync(() -> 10)
                .thenApply(n -> n * 2);

        System.out.println(future3.get());

        CompletableFuture<String> future4 = CompletableFuture.supplyAsync(() -> "Hello")
                .thenCompose(str -> CompletableFuture.supplyAsync(() -> str + " World"));

        System.out.println(future4.get());

        CompletableFuture<Integer> future5 = CompletableFuture.supplyAsync(() -> 10);
        CompletableFuture<Integer> future6 = CompletableFuture.supplyAsync(() -> 20);

        CompletableFuture<Integer> result2 = future5.thenCombine(future6, (a, b) -> a + b);
        System.out.println(result2.get());

        // Waits for both to finish
        //CompletableFuture<Void> allFutures = CompletableFuture.allOf(future5, future6);
        //allFutures.get();

        // CompletableFuture<Object> anyFuture = CompletableFuture.anyOf(future5, future6);
        //System.out.println(anyFuture.get()); // Outputs either 10 or 20

        CompletableFuture<Integer> future7 = CompletableFuture.supplyAsync(() -> {
            if (true) throw new RuntimeException("Error occurred!");
            return 10;
        }).exceptionally(ex -> {
            System.out.println("Exception: " + ex.getMessage());
            return 0;
        });

        System.out.println(future7.get());

        CompletableFuture<Integer> future8 = CompletableFuture.supplyAsync(() -> {
            if (true) throw new RuntimeException("Error!");
            return 10;
        }).handle((res, ex) -> {
            if (ex != null) {
                System.out.println("Exception: " + ex.getMessage());
                return -1;
            }
            return res;
        });

        System.out.println(future8.get());


        CompletableFuture<Integer> f1 = CompletableFuture.supplyAsync(() -> 10);
        CompletableFuture<Integer> f2 = CompletableFuture.supplyAsync(() -> 20);
        CompletableFuture<Integer> f3 = CompletableFuture.supplyAsync(() -> 30);
        CompletableFuture<Void> all = CompletableFuture.allOf(f1, f2, f3);
        all.thenRun(() -> System.out.println("All tasks completed!"));
        all.get();

    }
}

