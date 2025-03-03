package core.collectionframework.mapinterfc;

import java.util.EnumMap;

enum Days {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

public class EnumMapExample {
    public static void main(String[] args) {
        EnumMap<Days, String> schedule = new EnumMap<>(Days.class);
        // Adding values
        schedule.put(Days.MONDAY, "Gym");
        schedule.put(Days.WEDNESDAY, "Coding Practice");
        schedule.put(Days.FRIDAY, "Movie Night");

        // Printing EnumMap (Maintains Natural Order of Enum)
        System.out.println(schedule); // {MONDAY=Gym, WEDNESDAY=Coding Practice, FRIDAY=Movie Night}

        // Accessing values
        System.out.println("Activity on Wednesday: " + schedule.get(Days.WEDNESDAY));

        // Iterating over EnumMap
        for (Days day : schedule.keySet()) {
            System.out.println(day + ": " + schedule.get(day));
        }
    }
}
