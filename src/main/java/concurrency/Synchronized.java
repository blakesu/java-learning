package concurrency;

/**
 * Created by bsu on 2015/6/18.
 */
public class Synchronized {

    public static void main(String[] args) {
        ShareObject so = new ShareObject();
        CallerA a = new CallerA(so);
        a.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new CallerB(so).start();
    }

}
 class CallerA extends Thread {
    private ShareObject so = null;
    public CallerA( ShareObject so ){
        this.so = so;
    }
    @Override
    public void run() {
        so.A();
    }
}

 class CallerB extends Thread {
    private ShareObject so = null;
    public CallerB( ShareObject so ){
        this.so = so;
    }
    @Override
    public void run() {
        so.B();
    }
}

 class ShareObject {
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