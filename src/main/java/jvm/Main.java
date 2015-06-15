package jvm;

/**
 * Created by bsu on 2015/6/14.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println( System.nanoTime() );
        System.out.println( System.currentTimeMillis() );
        System.out.println( System.identityHashCode( "hello world" ) );

        System.out.println( Runtime.getRuntime().availableProcessors() );
        System.out.println( Runtime.getRuntime().maxMemory() );
        System.out.println( Runtime.getRuntime().totalMemory() );
        System.out.println( Runtime.getRuntime().freeMemory() );

    }
}
