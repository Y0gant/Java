package core.date_and_time;

import java.time.LocalDateTime;

public class LocalDateTimeExample {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Current Date & Time: " + now);

        LocalDateTime specificDateTime = LocalDateTime.of(2025, 3, 1, 10, 30, 45);
        System.out.println("Specific Date & Time: " + specificDateTime);

        LocalDateTime parsedDateTime = LocalDateTime.parse("2025-03-01T22:15:30");
        System.out.println("Parsed Date & Time: " + parsedDateTime);

        System.out.println("Get Components of Date & Time");
        int year = now.getYear();
        int month = now.getMonthValue();
        int dayOfMonth = now.getDayOfMonth();
        int hour = now.getHour();
        int minute = now.getMinute();
        int second = now.getSecond();

        System.out.println("Year: " + year);
        System.out.println("Month: " + month);
        System.out.println("Day: " + dayOfMonth);
        System.out.println("Hour: " + hour);
        System.out.println("Minute: " + minute);
        System.out.println("Second: " + second);

        LocalDateTime addedDays = now.plusDays(2);
        LocalDateTime addedHours = now.plusHours(5);
        LocalDateTime addedMinutes = now.plusMinutes(30);
        LocalDateTime subtractedMonths = now.minusMonths(1);

        System.out.println("Original Date & Time: " + now);
        System.out.println("After Adding 2 Days: " + addedDays);
        System.out.println("After Adding 5 Hours: " + addedHours);
        System.out.println("After Adding 30 Minutes: " + addedMinutes);
        System.out.println("After Subtracting 1 Month: " + subtractedMonths);

        LocalDateTime dateTime1 = LocalDateTime.of(2025, 2, 3, 12, 20, 40);
        LocalDateTime dateTime2 = LocalDateTime.of(2025, 2, 3, 0, 20, 40);

        System.out.println(dateTime1.isAfter(dateTime2));
        System.out.println(dateTime1.isBefore(dateTime2));
        System.out.println(dateTime1.isEqual(dateTime2));

    }
}
