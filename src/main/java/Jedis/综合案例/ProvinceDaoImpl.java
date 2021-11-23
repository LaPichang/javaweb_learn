package Jedis.综合案例;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import 综合练习_登录案例.JDBCutils;

import java.util.List;

public class ProvinceDaoImpl implements ProvinceDao{

    private JdbcTemplate template = new JdbcTemplate(JDBCutils.getDataSource());

    @Override
    public List<Province> findAll() {
        String sql = "select * from province";
        List<Province> list = template.query(sql, new BeanPropertyRowMapper<Province>(Province.class));
        return list;
    }
}
