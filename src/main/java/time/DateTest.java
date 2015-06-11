package time;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import java.util.Date;

/**
 * Created by bsu on 2014/10/14.
 */
public class DateTest {
    public static void main(String[] args) {
        System.out.println(new Date());
        System.out.println(new DateTime().withMillisOfSecond(0).toDate());
        System.out.println(new DateTime().withTime(18, 30, 0, 0).toDate());

        DateTime dt2 = new DateTime(DateTimeZone.forID("Europe/London"));
        System.out.println( dt2 );

        DateTime dt3 = new DateTime("2014-12-31");
        System.out.println( dt3.toString("yyyy-MM-dd") );

    }
}
