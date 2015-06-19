package concurrency;

import java.util.concurrent.*;

/**
 * Created by bsu on 2015/6/18.
 */
public class CallableTest {

    public static void main(String[] args) {
        ExecutorService pool = Executors.newSingleThreadExecutor();

        Future<String> f = pool.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "Hello";
            }
        });

        try {
            System.out.println( f.get() );
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        FutureTask<String> futureTask = new FutureTask<String>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "World";
            }
        });
        pool.submit(futureTask);

        try {
            System.out.println( futureTask.get() );
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        pool.shutdown();
    }

}
