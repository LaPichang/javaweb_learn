package Jedis;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Jedis连接池测试
 */

public class JedisTest02 {


    @Test
    public void test01() {
        // 创建配置对象
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(50);
        config.setMaxIdle(10);

        // 创建Jedis连接池对象
        JedisPool jedisPool = new JedisPool(config,"localhost",6379);

        // 获取连接
        Jedis jedis = jedisPool.getResource();
        // 使用
        jedis.set("name","zhangsan");

        // 关闭，归还连接池中
        jedis.close();
    }

}
