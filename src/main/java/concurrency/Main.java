package concurrency;

import org.apache.commons.pool2.impl.GenericObjectPool;

import java.io.IOException;
import java.io.StringReader;

/**
 * Created by bsu on 2015/6/10.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        ReaderUtil readerUtil = new ReaderUtil(new GenericObjectPool<StringBuffer>(new StringBufferFactory()));
        String result = readerUtil.readToString( new StringReader("hello world") );
        System.out.println( result );
    }
}
