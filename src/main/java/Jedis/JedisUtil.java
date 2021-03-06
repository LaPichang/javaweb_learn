package Jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Jedis 工具类
 */

public class JedisUtil {

    private static JedisPool jedisPool;

    static {
        // 读取配置文件
        InputStream is = JedisUtil.class.getClassLoader().getResourceAsStream("jedis.properties");
        // 创建 Properties对象
        Properties properties = new Properties();
        // 关联文件
        try {
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 获取数据，设置到JedisPoolConfig中
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(Integer.parseInt(properties.getProperty("maxTotal")));
        config.setMaxIdle(Integer.parseInt(properties.getProperty("maxIdle")));

        // 初始化JedisPool
        jedisPool = new JedisPool(config,properties.getProperty("host"),Integer.parseInt(properties.getProperty("port")));
    }

    public static Jedis getJedis() {
        return jedisPool.getResource();
    }
}
