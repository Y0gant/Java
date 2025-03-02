package core.date_and_time;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class OffsetDateTimeExample {
    public static void main(String[] args) {
        OffsetDateTime now = OffsetDateTime.now();
        System.out.println("Current Offset Date&Time: " + now);

        OffsetDateTime specifiedOffset = OffsetDateTime.now(ZoneOffset.of("+02:00"));
        System.out.println("+2.00 offset from current time: " + specifiedOffset);

        LocalDateTime nowDateTime = LocalDateTime.now();
        OffsetDateTime convertedDateTime = nowDateTime.atOffset(ZoneOffset.of("+05:30"));
        System.out.println("Current time using LocalDateTime converted to OffsetDateTime: " + convertedDateTime);

        OffsetDateTime parsedDateTime = OffsetDateTime.parse("2025-07-23T12:30:45.123+05:30");
        System.out.println("Parsed date and time from a string " + parsedDateTime);

        OffsetDateTime offsetDateTime = OffsetDateTime.now();
        System.out.println("Year: " + offsetDateTime.getYear());
        System.out.println("Month: " + offsetDateTime.getMonth());
        System.out.println("Day of Month: " + offsetDateTime.getDayOfMonth());
        System.out.println("Hour: " + offsetDateTime.getHour());
        System.out.println("Minute: " + offsetDateTime.getMinute());

        OffsetDateTime utcTime = offsetDateTime.withOffsetSameInstant(ZoneOffset.UTC);

        System.out.println("Current offset: " + offsetDateTime.getOffset());
        System.out.println("Original Offset Date-Time: " + offsetDateTime);
        System.out.println("Converted to UTC: " + utcTime);

        OffsetDateTime future = now.plusDays(10).plusHours(5);

        System.out.println("Now: " + now);
        System.out.println("Future (10 days, 5 hours later): " + future);

        System.out.println("Now is before Future? " + now.isBefore(future));
        System.out.println("Now is after Future? " + now.isAfter(future));
    }
}
