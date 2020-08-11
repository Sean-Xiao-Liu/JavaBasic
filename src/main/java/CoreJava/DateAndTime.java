package CoreJava;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateAndTime {
    public static void main(String[] args) {
        /** 1. Local time class*/
        LocalDate localDate = LocalDate.now().minus(1, ChronoUnit.CENTURIES); // show the date of a month ago
        System.out.println(localDate);

        LocalTime localTime = LocalTime.now();
        System.out.println("The current time is " +  localTime); // only time, no date

        LocalDateTime current = LocalDateTime.now();
        System.out.println("The current data and time is " + current);

        // to print in a particular format
        DateTimeFormatter format =
                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        String formatedDateTime = current.format(format);

        System.out.println("in foramatted manner "+
                formatedDateTime);


        // printing months days and seconds
        Month month = current.getMonth();
        int day = current.getDayOfMonth();
        int seconds = current.getSecond();
        System.out.println("Month : "+month+" day : "+
                day+" seconds : "+seconds);

        // printing some specified date
        LocalDate date2 = LocalDate.of(1950,1,26);
        System.out.println("the repulic day :"+date2);

        /** 2. Zoned date and time */

        // to get the current zone
        ZonedDateTime currentZone = ZonedDateTime.now();
        System.out.println("the current zone is "+
                currentZone.getZone());

        ZoneId tokyo = ZoneId.of("Asia/Tokyo");

        ZonedDateTime tokyoZone =
                currentZone.withZoneSameInstant(tokyo);

        System.out.println("tokyo time zone is " +
                tokyoZone);

        /** 3. Add date and time */
        LocalDate now = LocalDate.now();
        System.out.println(now);
        now.plusDays(30);
        System.out.println(now);
        now = now.plusMonths(1);
        System.out.println(now);
    }
}
