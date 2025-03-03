package core.date_and_time;

import java.time.LocalDate;
import java.time.Period;

public class PeriodExample {
    public static void main(String[] args) {
        Period period = Period.of(2, 5, 10);
        System.out.println("Period: " + period);
        System.out.println("P (Period), 2Y (2 Years), 5M (5 Months), 10D (10 Days).");

        LocalDate start = LocalDate.of(2020, 1, 1);
        LocalDate end = LocalDate.of(2023, 6, 15);
        Period period1 = Period.between(start, end);
        System.out.println("Period: " + period1);
        System.out.println("Years: " + period1.getYears());
        System.out.println("Months: " + period1.getMonths());
        System.out.println("Days: " + period1.getDays());

        Period p1 = Period.ofYears(3);
        Period p2 = Period.ofMonths(6);
        Period p3 = Period.ofWeeks(4); // Converted to days internally
        Period p4 = Period.ofDays(10);

        System.out.println("Years: " + p1);
        System.out.println("Months: " + p2);
        System.out.println("Weeks: " + p3);
        System.out.println("Days: " + p4);

        Period increased = period.plusMonths(3);
        Period decreased = period.minusDays(5);

        System.out.println("Original Period: " + period);
        System.out.println("After Adding 3 months: " + increased);
        System.out.println("After Subtracting 5 days: " + decreased);

        System.out.println("Compare Two Period Objects");
        System.out.println("p1 is Zero? " + p1.isZero());
        System.out.println("p1 is Negative? " + p1.isNegative());
        System.out.println("p1 equals p3? " + p1.equals(p3)); // true


        String formatted = period.toString();
        System.out.println("Convert Period to String");
        System.out.println("Formatted Period: " + formatted);
    }
}
