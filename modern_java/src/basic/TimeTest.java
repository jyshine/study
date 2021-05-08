package basic;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

/**
 * Time
 */
public class TimeTest {
    //Date , Time Api 제공
    //Joda-Time 라이브러 java se8 부터 새롭게 디자인!

    public static void main(String[] args) {
        LocalDateTime timePoint = LocalDateTime.now();
        System.out.println(timePoint);

        LocalDate ld1 = LocalDate.of(2012, Month.DECEMBER, 12);
        System.out.println(ld1);

        LocalTime lt1 = LocalTime.of(12, 12);
        System.out.println(lt1);

        LocalTime lt2 = LocalTime.parse("10:10:30");
        System.out.println(lt2);

        LocalDate justDate = timePoint.toLocalDate();
        System.out.println(justDate);
        System.out.println(timePoint.getMonth());

        Month month = timePoint.getMonth();
        System.out.println(month.getValue());


    }


}
