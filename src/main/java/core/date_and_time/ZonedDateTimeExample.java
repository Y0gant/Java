package core.date_and_time;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ZonedDateTimeExample {
    public static void main(String[] args) {
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println("Current Date&Time with Zone information: " + now);

        ZonedDateTime specificZonedDateTime = ZonedDateTime.now(ZoneId.of("America/New_York"));
        System.out.println("Date & Time of specified zone: " + specificZonedDateTime);

        System.out.println("Zoned Date&Time using LocalDate class");
        ZonedDateTime currentLondon = LocalDateTime.now().atZone(ZoneId.of("Europe/London"));
        System.out.println("Current Date&Time in london: " + currentLondon);

        ZonedDateTime parsedZoned = ZonedDateTime.parse("2025-03-01T12:30:45+05:30[Asia/Kolkata]");
        System.out.println("Parsed Zoned from a string: " + parsedZoned);

        System.out.println("Date-Time Component Retrieval using methods");
        System.out.println("Year " + now.getYear());
        System.out.println("Month " + now.getDayOfMonth());
        System.out.println("Day " + now.getDayOfWeek());
        System.out.println("Day-of-year " + now.getDayOfYear());
        System.out.println("Hour " + now.getHour());
        System.out.println("Minute " + now.getMinute());
        System.out.println("Second " + now.getSecond());
        System.out.println("Nano Seconds " + now.getNano());

        System.out.println("Current Time Zone Information");
        System.out.println("ZoneID " + now.getZone());
        System.out.println("UTC Offset " + now.getOffset());
        ZonedDateTime indiaTime = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
        ZonedDateTime newYorkTime = indiaTime.withZoneSameInstant(ZoneId.of("America/New_York"));

        System.out.println("India Time: " + indiaTime);
        System.out.println("New York Time: " + newYorkTime);
        System.out.println("Changed New-York zone to London retaining the New-York time " + newYorkTime.withZoneSameLocal(ZoneId.of("Europe/London")));

        System.out.println("Date-Time Modification Methods");
        ZonedDateTime future = now.plusDays(10).plusHours(5);

        System.out.println("Now: " + now);
        System.out.println("Future (10 days, 5 hours later): " + future);

        System.out.println("Comparing ZonedDateTime");
        ZonedDateTime futureTime = now.plusDays(1);
        System.out.println("Now is before Future? " + now.isBefore(futureTime));
        System.out.println("Now is after Future? " + now.isAfter(futureTime));
        
    }
}
