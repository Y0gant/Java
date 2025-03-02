package core.date_and_time;

import java.time.Duration;
import java.time.Instant;

public class InstantExample {
    public static void main(String[] args) {
        Instant now = Instant.now();
        System.out.println("Current UTC time-stamp: " + now);

        Instant epoch = Instant.ofEpochSecond(0);
        System.out.println("Java Epoch time: ");
        Instant fromSeconds = Instant.ofEpochSecond(1749531200);

        System.out.println("Epoch Instant: " + epoch);
        System.out.println("Instant from Seconds: " + fromSeconds);

        System.out.println("Convert Instant from Milliseconds/Nanoseconds");
        Instant fromMillis = Instant.ofEpochMilli(1672531200000L);
        Instant fromNanos = Instant.ofEpochSecond(1672531200, 500000000);

        System.out.println("Instant from Milliseconds: " + fromMillis);
        System.out.println("Instant from Nanoseconds: " + fromNanos);

        Instant parsedInstant = Instant.parse("2025-03-01T07:45:30.123456Z");
        System.out.println("Parsed Instant: " + parsedInstant);

        System.out.println("Epoch Seconds: " + now.getEpochSecond());
        System.out.println("Nanoseconds: " + now.getNano());
        System.out.println("Milliseconds: " + now.toEpochMilli());

        Instant future = now.plusSeconds(3600);
        Instant past = now.minusMillis(5000);

        System.out.println("Now: " + now);
        System.out.println("Future (1 hour later): " + future);
        System.out.println("Past (5 sec earlier): " + past);

        System.out.println("Now is before Future? " + now.isBefore(future));
        System.out.println("Now is after Future? " + now.isAfter(future));

        System.out.println("Convert Instant to Other Date-Time Types");
        System.out.println("Now is before Future? " + now.isBefore(future));
        System.out.println("Now is after Future? " + now.isAfter(future));

        Instant start = Instant.now();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Instant end = Instant.now();
        Duration duration = Duration.between(start, end);

        System.out.println("Time elapsed: " + duration.toMillis() + " milliseconds");
    }
}
