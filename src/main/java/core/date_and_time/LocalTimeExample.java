package core.date_and_time;

import java.time.LocalTime;

public class LocalTimeExample {
    public static void main(String[] args) {
        LocalTime now = LocalTime.now();
        System.out.println("Current time: " + now);

        //custom time
        LocalTime specificTime = LocalTime.of(10, 30, 45); // 10:30:45 AM
        System.out.println("Specific Time: " + specificTime);

        //Parse Time from a String (HH:mm:ss format)
        LocalTime parsedTime = LocalTime.parse("22:15:30");
        System.out.println("Parsed time: " + parsedTime);

        System.out.println("Components of time");
        int hour = now.getHour();
        int minute = now.getMinute();
        int second = now.getSecond();
        int nano = now.getNano();

        System.out.println("Current ->");
        System.out.println("Hour: " + hour);
        System.out.println("Minute: " + minute);
        System.out.println("Second: " + second);
        System.out.println("Nanosecond: " + nano);

        //Manipulating Time (Adding and Subtracting)
        LocalTime plusHours = now.plusHours(2);
        LocalTime plusMinutes = now.plusMinutes(30);
        LocalTime plusSeconds = now.plusSeconds(450);
        LocalTime plusNanos = now.plusNanos(20000000);
        LocalTime minusHours = now.minusHours(3);
        LocalTime minusMinutes = now.minusMinutes(40);
        LocalTime minusSeconds = now.minusSeconds(30);
        LocalTime minusNanos = now.minusNanos(1234231);

        System.out.println("2 hours from now: " + plusHours);
        System.out.println("30 minutes from now: " + plusMinutes);
        System.out.println("450 seconds from now: " + plusSeconds);
        System.out.println("20000000 nanoseconds from now: " + plusNanos);
        System.out.println("3 hours before now: " + minusHours);
        System.out.println("40 minutes before now: " + minusMinutes);
        System.out.println("30 seconds before now: " + minusSeconds);
        System.out.println("1234231 nanoseconds before now: " + minusNanos);

        //Comparing Times
        LocalTime time1 = LocalTime.of(10, 30);
        LocalTime time2 = LocalTime.of(12, 45);

        System.out.println(time1.isBefore(time2));
        System.out.println(time1.isAfter(time2));
        System.out.println(time1.equals(time2));

        // Finding the Start or End of the Day
        LocalTime midnight = LocalTime.MIDNIGHT;
        LocalTime noon = LocalTime.NOON;
        LocalTime minTime = LocalTime.MIN;
        LocalTime maxTime = LocalTime.MAX;

        System.out.println("Midnight: " + midnight);
        System.out.println("Noon: " + noon);
        System.out.println("Minimum Time: " + minTime);
        System.out.println("Maximum Time: " + maxTime);
    }
}
