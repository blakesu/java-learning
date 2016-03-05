package redis;

import redis.clients.jedis.Jedis;

/**
 * Created by sublake on 16/2/6.
 */
public class RedisTest {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.2.155");
        //jedis.set("foo", "bar");
        String value = jedis.get("foo");
        System.out.println( value );
    }
}
