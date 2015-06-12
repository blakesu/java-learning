package bigdecimal;

import java.math.BigDecimal;

/**
 * Created by bsu on 2015/6/11.
 */
public class Main {
    public static void main(String[] args) {
        BigDecimal b1 = new BigDecimal("1.0000");
        BigDecimal b2 = new BigDecimal("1.0");
        System.out.println(  b1.equals( b2) );
        System.out.println(  b1.compareTo( b2 ) == 0 );
    }
}
