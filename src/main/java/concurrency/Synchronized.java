package concurrency;

/**
 * Created by bsu on 2015/6/18.
 */
public class Synchronized {

    public static void main(String[] args) {
        SynchronizedTest test = new SynchronizedTest();
        CallerA a = new CallerA(test);
        a.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new CallerB(test).start();
    }

    static class CallerA extends Thread {
        private SynchronizedTest test = null;
        public CallerA( SynchronizedTest test ){
            this.test = test;
        }
        @Override
        public void run() {
            test.A();
        }
    }

    static class CallerB extends Thread {
        private SynchronizedTest test = null;
        public CallerB( SynchronizedTest test ){
            this.test = test;
        }
        @Override
        public void run() {
            test.B();
        }
    }

    static class SynchronizedTest {
        public synchronized void  A(){
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println( "A" );
        }

        public synchronized void  B(){
            System.out.println( "B" );
        }
    }

}
