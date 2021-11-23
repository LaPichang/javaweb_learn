package Jedis;

import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * Jedis工具类测试
 */

public class JedisUtilTest {

    @Test
    public void test1(){

        // 通过连接池工具类获取
        Jedis jedis = JedisUtil.getJedis();

        jedis.set("score","150");

        String score = jedis.get("score");
        System.out.println(score);

        jedis.close();
    }

}
