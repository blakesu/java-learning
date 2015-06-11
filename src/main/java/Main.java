import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 * Created by bsu on 2015/1/13.
 */
public class Main {
    public static void main(String[] args) {
        BigDecimal b1 = new BigDecimal("1.0000");
        BigDecimal b2 = new BigDecimal("1.0");
        System.out.println(  b1.equals( b2) );
        System.out.println(  b1.compareTo( b2 ) == 0 );

        System.out.println( "\u0041" );

        List l = Arrays.asList( new String[]{ "a","b","c","d" } );
        System.out.println( l.subList( 1,4 ) );
        Collections.shuffle(l);
        System.out.println(  l);
    }
}
