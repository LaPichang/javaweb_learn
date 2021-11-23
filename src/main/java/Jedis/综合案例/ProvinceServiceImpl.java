package Jedis.综合案例;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import redis.clients.jedis.Jedis;

import Jedis.JedisUtil;

import java.util.List;

public class ProvinceServiceImpl implements ProvinceService{

    private ProvinceDao dao = new ProvinceDaoImpl();

    @Override
    public List<Province> findAll() {
        return dao.findAll();
    }

    @Override
    public String findAllJson() {
        // 先从redis 中查询数据
        // 获取redis 客户端连接
        Jedis jedis = JedisUtil.getJedis();
        String province_json = jedis.get("province");

        // 判断 province_json 数据是否为null
        if(province_json == null || province_json.length() == 0){
            // redis中没有数据
            System.out.println("redis中没有数据，查询数据库");
            // 从数据库中查询
            List<Province> ps = dao.findAll();
            // 将list 序列化为json
            ObjectMapper mapper = new ObjectMapper();
            try {
                province_json = mapper.writeValueAsString(ps);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }

            // 将json 数据存入redis
            jedis.set("province",province_json);
            // 归还连接
            jedis.close();
        }else {
            System.out.println("redis中有数据，查询缓存");
        }
        return province_json;
    }


}
