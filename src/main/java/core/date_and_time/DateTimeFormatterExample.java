package core.date_and_time;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class DateTimeFormatterExample {
    public static void main(String[] args) {
        System.out.println("Predefined formatters");
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
        String formattedDateTime = now.format(formatter);
        System.out.println("Formatted Date_Time: " + formattedDateTime);

        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter1 = DateTimeFormatter.ISO_DATE;
        String formattedDate = today.format(formatter1);
        System.out.println("Formatted Date: " + formattedDate);

        LocalTime current = LocalTime.now();
        DateTimeFormatter formatter2 = DateTimeFormatter.ISO_TIME;
        String formattedTime = current.format(formatter2);
        System.out.println("Formatted Time: " + formattedTime);

        ZonedDateTime currentZoned = ZonedDateTime.now();
        DateTimeFormatter formatter3 = DateTimeFormatter.ISO_ZONED_DATE_TIME;
        String formattedZonedDateTime = currentZoned.format(formatter3);
        System.out.println("Formatted Zoned Date_Time: " + formattedZonedDateTime);

        OffsetDateTime currentOffset = OffsetDateTime.now();
        DateTimeFormatter formatter4 = DateTimeFormatter.ISO_OFFSET_DATE_TIME;
        String formattedOffset = currentOffset.format(formatter4);
        System.out.println("Formatted Offset Date_Time: " + formattedOffset);

        DateTimeFormatter formatter5 = DateTimeFormatter.RFC_1123_DATE_TIME;
        String rfcZoned = currentZoned.format(formatter5);
        System.out.println("RFC_1123_DATE_TIME Format: " + rfcZoned);


        DateTimeFormatter customFormatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm:ss a");
        String customFormatted = now.format(customFormatter);
        System.out.println("Date_Time with custom format(\"dd-MMM-yyyy HH:mm:ss a\"): " + customFormatted);

        String dateStr = "01-Mar-2025";
        DateTimeFormatter parseFormatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
        LocalDate date = LocalDate.parse(dateStr, parseFormatter);
        System.out.println("Parsed LocalDate: " + date);

        DateTimeFormatter customFormatter2 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss z");
        String formattedZonedDate = currentZoned.format(customFormatter2);
        System.out.println("Formatted Custom ZonedDateTime(\"dd-MM-yyyy HH:mm:ss z\"): " + formattedZonedDate);

        DateTimeFormatter localeFormatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG).withLocale(Locale.JAPANESE);
        String japaneseLocaleDateTime = currentZoned.format(localeFormatter);
        System.out.println("Date_Time in Japanese Locale: " + japaneseLocaleDateTime);
    }
}
