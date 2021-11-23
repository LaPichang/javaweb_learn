package Jedis;


import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * jedis 测试类
 */

public class JedisTest01 {

    @Test
    public void test1(){
        // 获取连接
        Jedis jedis = new Jedis("localhost",6379);
        // 操作
        jedis.set("username","WDF");
        // 关闭连接
        jedis.close();
    }

    @Test
    public void test2(){
        Jedis jedis = new Jedis();// 空参默认值localhost,6379
        jedis.set("username2","ZWC");
        // 获取
        String username2 = jedis.get("username2");
        System.out.println(username2);
        jedis.close();
    }
}
