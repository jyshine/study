package basic;

import java.util.Calendar;

/**
 * calendar
 */
public class CalendarTest {
    //Date 클래스 지역화 안된다는 단점 업글

    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();

        System.out.println(cal.get(Calendar.YEAR));
        System.out.println(cal.get(Calendar.MONTH)+1);
        System.out.println(cal.get(Calendar.DATE));
        System.out.println(cal.get(Calendar.HOUR));
        System.out.println(cal.get(Calendar.HOUR_OF_DAY));

        cal.add(Calendar.DATE, 5);

        StringBuffer sb = new StringBuffer();
        sb.append(cal.get(Calendar.YEAR));
        sb.append("년");
        sb.append(cal.get(Calendar.MONTH)+1);
        sb.append("월");
        sb.append(cal.get(Calendar.DATE));
        sb.append("일");

        System.out.println(sb.toString());


    }

}
