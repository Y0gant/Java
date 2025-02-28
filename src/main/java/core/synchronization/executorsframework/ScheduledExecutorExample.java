package core.synchronization.executorsframework;


import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorExample {

    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(5);

        scheduler.schedule(() -> System.out.println("Task executed after 5 second delay")
                , 5
                , TimeUnit.SECONDS);

        scheduler.scheduleAtFixedRate(
                () -> System.out.println("Task executed after every 3 second of delay")
                , 5
                , 3
                , TimeUnit.SECONDS);

        scheduler.scheduleWithFixedDelay(() -> System.out.println("Task executed after every 2 second of delay")
                , 10
                , 2
                , TimeUnit.SECONDS);

        scheduler.schedule(() -> {
                    System.out.println("Initiating scheduler shutdown");
                    scheduler.shutdown();
                },
                20,
                TimeUnit.SECONDS);

    }
}
