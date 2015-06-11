package timer;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by bsu on 2015/1/24.
 */
public class TimerTest {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                System.out.println("abc");
                throw new RuntimeException("exception");
            }
        }, 1000 , 1000);
    }
}
