package CoreJava;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateAndTime {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now().minus(1, ChronoUnit.MONTHS); // show the date of a month ago
        System.out.println(localDate);
    }
}
