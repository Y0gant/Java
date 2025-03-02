package core.date_and_time;

import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

public class TimeConversion {
    public static void main(String[] args) {
        System.out.println("Convert LocalTime to java.util.Date and Vice Versa");
        // LocalTime to java.util.Date (Time is always 1970-01-01 + LocalTime)
        LocalTime localTime = LocalTime.now();
        Instant instant = localTime.atDate(java.time.LocalDate.of(1970, 1, 1))
                .atZone(ZoneId.systemDefault())
                .toInstant();
        Date date = Date.from(instant);
        System.out.println("Converted Date: " + date);

        // java.util.Date to LocalTime
        Date utilDate = new Date();
        LocalTime convertedLocalTime = utilDate.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
        System.out.println("Converted LocalTime: " + convertedLocalTime);
    }
}
