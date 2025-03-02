package core.date_and_time;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class DateTimeConversion {
    public static void main(String[] args) {
        System.out.println("Convert LocalDateTime to java.util.Date and Vice Versa");
        // LocalDateTime to java.util.Date
        LocalDateTime localDateTime = LocalDateTime.now();
        Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
        Date date = Date.from(instant);
        System.out.println("Converted Date: " + date);

        // java.util.Date to LocalDateTime
        Date utilDate = new Date();
        LocalDateTime convertedLocalDateTime = utilDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        System.out.println("Converted LocalDateTime: " + convertedLocalDateTime);
    }
}

