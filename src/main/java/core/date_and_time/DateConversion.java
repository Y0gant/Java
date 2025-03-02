package core.date_and_time;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DateConversion {
    public static void main(String[] args) {
        System.out.println("Convert LocalDate to java.util.Date and Vice Versa");
        // LocalDate to java.util.Date
        LocalDate localDate = LocalDate.now();
        Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        System.out.println("Converted Date: " + date);

        // java.util.Date to LocalDate
        Date utilDate = new Date();
        LocalDate convertedLocalDate = utilDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        System.out.println("Converted LocalDate: " + convertedLocalDate);
    }
}
