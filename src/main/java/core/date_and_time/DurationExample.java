package core.date_and_time;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;

public class DurationExample {
    public static void main(String[] args) {
        Duration duration = Duration.ofHours(2);
        System.out.println(duration);
        System.out.println("PT2H → P (Period), T (Time), 2H (2 Hours).");

        Instant start = Instant.now();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Instant end = Instant.now();
        Duration durationBetween = Duration.between(start, end);

        System.out.println("Time elapsed: " + durationBetween.toMillis() + " milliseconds");

        LocalTime start2 = LocalTime.of(10, 30);
        LocalTime end2 = LocalTime.of(12, 45);

        Duration duration2 = Duration.between(start2, end2);
        System.out.println("Duration: " + duration2);

        Duration d1 = Duration.ofDays(2);
        Duration d2 = Duration.ofHours(5);
        Duration d3 = Duration.ofMinutes(30);
        Duration d4 = Duration.ofSeconds(45);
        Duration d5 = Duration.ofMillis(500);
        Duration d6 = Duration.ofNanos(1000000);

        System.out.println("Days: " + d1);
        System.out.println("Hours: " + d2);
        System.out.println("Minutes: " + d3);
        System.out.println("Seconds: " + d4);
        System.out.println("Milliseconds: " + d5);
        System.out.println("Nanoseconds: " + d6);

        System.out.println("Get Values from a Duration");
        System.out.println("Days: " + duration.toDays());
        System.out.println("Hours: " + duration.toHours());
        System.out.println("Minutes: " + duration.toMinutes());
        System.out.println("Seconds: " + duration.toSeconds());
        System.out.println("Milliseconds: " + duration.toMillis());
        System.out.println("Nanoseconds: " + duration.toNanos());

        System.out.println("Modify Duration (Add or Subtract Time)");
        Duration increased = duration.plusMinutes(30);
        Duration decreased = duration.minusHours(1);

        System.out.println("Original Duration: " + duration);
        System.out.println("After Adding 30 min: " + increased);
        System.out.println("After Subtracting 1 hours: " + decreased);

        System.out.println("Compare Two Duration Objects");
        System.out.println("d1 is Zero? " + d1.isZero());
        System.out.println("d1 is Negative? " + d1.isNegative());
        System.out.println("d1 equals d2? " + d1.equals(d2));
        System.out.println("d2 compared to d3: " + d2.compareTo(d3));
        System.out.println("d2 -" + d2 + " d3-" + d3);

        System.out.println("Convert Duration to String");
        String formatted = duration.toString();
        System.out.println(formatted);
    }
}
