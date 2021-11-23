package 综合案例_分页表单;

import org.junit.Test;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UserServiceImpl implements UserService {


    private JdbcTemplate template = new JdbcTemplate(JDBCutils.getDataSource());

    @Override
    public List<User> findAll() {
        //使用JDBC操作数据库...
        //1.定义sql
        String sql = "select * from user3";
        List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class));

        return users;
    }

    @Override
    public User login(User loginUser) {

        // 编写SQL
        String sql = "select * from USER2 where username = ? and password = ?";
        // 调用query方法
        try {
            User user = template.queryForObject(sql,
                    new BeanPropertyRowMapper<User>(User.class),
                    loginUser.getUsername(),
                    loginUser.getPassword());
            return user;
        } catch (DataAccessException e) {
            return null;
        }
    }

    @Override
    public void addUser(User user) {
        String sql = "insert into user3 values(null,?,?,?,?,?,null,null)";
        // 执行sql
        JdbcTemplate template = new JdbcTemplate(JDBCutils.getDataSource());
        template.update(sql, user.getName(), user.getAddress(), user.getEmail(), user.getGender(), user.getAge());
    }

    @Override
    public void delete(String id) {
        String sql = "delete from user3 where id = ?";
        template.update(sql, id);
    }

    @Override
    public User findUserById(String id) {
        String sql = "select * from user3 where id = ?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), id);
    }

    @Override
    public void updateUser(User user) {
        String sql = "update user3 set name = ?,address = ?,email = ?,gender = ?,age = ? where id = ?";
        template.update(sql, user.getName(), user.getAddress(), user.getEmail(), user.getGender(), user.getAge(), user.getId());
    }

    @Override
    public void delSelect(String[] ids) {
        String sql = "delete from user3 where id = ?";
        for (String id : ids) {
            template.update(sql, id);
        }
    }

    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        String sql = "select count(*) from user3 where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);

        // 遍历map
        Set<String> keySet = condition.keySet();
        // 定义参数集合
        List<Object> params = new ArrayList<Object>();
        for (String key : keySet) {

            // 排除分页条件参数
            if ("currentPage".equals(key) || "rows".equals(key)) {
                continue;
            }

            // 获取value
            String value = condition.get(key)[0];
            // 判断value 是否有值
            if (value != null && !"".equals(value)) {
                // 有值
                sb.append(" and " + key + " like ? ");
                params.add("%" + value + "%"); // 条件值
            }
        }

        return template.queryForObject(sb.toString(), Integer.class, params.toArray());
    }

    @Override
    public List<User> findByPage(int start, int rows, Map<String, String[]> condition) {
        String sql = "select * from user3 where 1 = 1 ";

        StringBuilder sb = new StringBuilder(sql);

        // 遍历map
        Set<String> keySet = condition.keySet();
        // 定义参数集合
        List<Object> params = new ArrayList<Object>();
        for (String key : keySet) {

            // 排除分页条件参数
            if ("currentPage".equals(key) || "rows".equals(key)) {
                continue;
            }

            // 获取value
            String value = condition.get(key)[0];
            // 判断value 是否有值
            if (value != null && !"".equals(value)) {
                // 有值
                sb.append(" and " + key + " like ? ");
                params.add("%" + value + "%"); // 条件值
            }

        }
        // 添加分页查询
        sb.append(" limit ?,? ");
        // 添加分页查询的参数值
        params.add(start);
        params.add(rows);


        return template.query(sb.toString(), new BeanPropertyRowMapper<User>(User.class),params.toArray());
    }

}
