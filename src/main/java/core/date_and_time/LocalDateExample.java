package core.date_and_time;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;

public class LocalDateExample {
    public static void main(String[] args) {
        //Get the Current Date
        LocalDate currentDate = LocalDate.now();
        System.out.println("Today's Date is: " + currentDate);

        //Create a Specific Date
        LocalDate customDate = LocalDate.of(1999, 8, 22);
        System.out.println("Custom date: " + customDate);

        //Parse a Date from a String (yyyy-MM-dd format)
        LocalDate parsedDate = LocalDate.parse("2023-08-15");
        System.out.println("Parsed date from a string " + parsedDate);

        //Get Components of a Date
        int year = currentDate.getYear();
        Month month = currentDate.getMonth();
        int dayOfMonth = currentDate.getDayOfMonth();
        int dayOfYear = currentDate.getDayOfYear();
        DayOfWeek dayOfWeek = currentDate.getDayOfWeek();

        System.out.println("current day: " + dayOfMonth);
        System.out.println("current month: " + month);
        System.out.println("current year: " + year);
        System.out.println("current day of year: " + dayOfYear);
        System.out.println("current day of week: " + dayOfWeek);

        //Manipulating dates
        LocalDate today = LocalDate.now();
        LocalDate futureDate = today.plusDays(10); // Adds 10 days
        LocalDate pastDate = today.minusMonths(2); // Subtracts 2 months
        LocalDate nextYear = today.plusYears(1); // Adds 1 year

        System.out.println("Today's: " + today);
        System.out.println("10 days from today: " + futureDate);
        System.out.println("2 month's before today: " + pastDate);
        System.out.println("1 year from today: " + nextYear);

        //comparing dates
        LocalDate date1 = LocalDate.of(2025, 3, 1);
        LocalDate date2 = LocalDate.of(2024, 12, 31);

        System.out.println("Is " + date1 + " after " + date2 + ": " + date1.isAfter(date2));
        System.out.println("Is " + date1 + " before " + date2 + ": " + date1.isBefore(date2));
        System.out.println("Is " + date1 + " equal to " + date2 + ": " + date1.isEqual(date2));

        //Checking for Leap Year
        System.out.println("Is this leap year? " + today.isLeapYear());

        //Finding the Next or Previous Day of the Week
        LocalDate nextMonday = today.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        LocalDate previousFriday = today.with(TemporalAdjusters.previous(DayOfWeek.FRIDAY));

        System.out.println("Next Monday: " + nextMonday);
        System.out.println("Previous Friday: " + previousFriday);


        //Get the First or Last Day of the Month/Year
        LocalDate firstDayOfMonth = today.with(TemporalAdjusters.firstDayOfMonth());
        LocalDate lastDayOfMonth = today.with(TemporalAdjusters.lastDayOfMonth());

        LocalDate firstDayOfYear = today.with(TemporalAdjusters.firstDayOfYear());
        LocalDate lastDayOfYear = today.with(TemporalAdjusters.lastDayOfYear());

        System.out.println("First Day of Month: " + firstDayOfMonth);
        System.out.println("Last Day of Month: " + lastDayOfMonth);
        System.out.println("First Day of Year: " + firstDayOfYear);
        System.out.println("Last Day of Year: " + lastDayOfYear);
    }
}
