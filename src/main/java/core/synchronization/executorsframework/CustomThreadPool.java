package core.synchronization.executorsframework;

import java.util.concurrent.*;

public class CustomThreadPool {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2, 4, 10, TimeUnit.SECONDS, new LinkedBlockingQueue<>(2));

        for (int i = 1; i <= 6; i++) {
            executor.execute(() -> System.out.println(Thread.currentThread().getName() + " executing task"));
        }

        executor.shutdown();
    }
}

