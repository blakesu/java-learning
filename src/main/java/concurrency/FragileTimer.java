package concurrency;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by bsu on 2015/6/11.
 */
public class FragileTimer {

    public static void main(String[] args) throws InterruptedException {
        Timer timer = new Timer();
        timer.schedule( new ThrowTask(), 1);
        Thread.sleep(1000);
        timer.schedule( new ThrowTask(), 1);
        Thread.sleep(5000);
    }

    static class ThrowTask extends TimerTask{
        public void run(){
            throw new RuntimeException();
        }
    }
}
