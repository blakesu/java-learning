package collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by bsu on 2015/6/11.
 */
public class Main {
    public static void main(String[] args) {

        List l = Arrays.asList(new String[]{"a", "b", "c", "d"});
        System.out.println( l.subList( 1,4 ) );
        Collections.shuffle(l);
        System.out.println(  l);
    }
}
