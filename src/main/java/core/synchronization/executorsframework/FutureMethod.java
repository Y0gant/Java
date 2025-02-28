package core.synchronization.executorsframework;

import java.util.List;
import java.util.concurrent.*;

public class FutureMethod {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<?> future1 = executor.submit(() -> System.out.println("Executing a task.."), "Success");
        System.out.println("Returned :" + future1.get());
        if (future1.isDone()) {
            System.out.println("Task completed.");
        }

        Future<String> future2 = executor.submit(() -> " a string.");
        System.out.println("Returned :" + future2.get());
        if (future2.isDone()) {
            System.out.println("Task completed.");
        }

        Future<Integer> future3 = executor.submit(() -> 200 * 2);
        System.out.println("Returned :" + future3.get());
        if (future3.isDone()) {
            System.out.println("Task completed.");
        }

        List<Callable<String>> tasks = List.of(
                () -> {
                    Thread.sleep(1000);
                    return "Task 1";
                },
                () -> {
                    Thread.sleep(2000);
                    return "Task 2";
                }
        );

        String result = executor.invokeAny(tasks);
        System.out.println("First completed task: " + result);

        List<Callable<String>> tasks2 = List.of(
                () -> {
                    Thread.sleep(1000);
                    return "Task 1";
                },
                () -> {
                    Thread.sleep(1000);
                    return "Task 2";
                }, () -> {
                    Thread.sleep(1000);
                    return "Task 3";
                }, () -> {
                    Thread.sleep(1000);
                    return "Task 4";
                }, () -> {
                    Thread.sleep(1000);
                    return "Task 5";
                }, () -> {
                    Thread.sleep(1000);
                    return "Task 6";
                }, () -> {
                    Thread.sleep(1000);
                    return "Task 7";
                }
        );

        List<Future<String>> results = executor.invokeAll(tasks2);

        for (Future<String> st : results) {
            System.out.println(st.get() + " completed");
        }
        executor.shutdown();
        Thread.sleep(10);
        System.out.println("All tasks completed :" + executor.isTerminated());
        System.out.println("executor closed :" + executor.isShutdown());

    }
}
