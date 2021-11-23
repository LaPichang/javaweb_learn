package 综合练习_登录案例;


import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 操作数据库中User表的类
 */

public class UserSQL {


    // 声明JDBCTemplate对象共用
    JdbcTemplate template = new JdbcTemplate(JDBCutils.getDataSource());

    /**
     * 登录方法
     * @param loginUser 只用用户名和密码
     * @return user 包含用户全部信息
     */
    public User login(User loginUser){

        // 编写SQL
        String sql = "select * from USER where username = ? and password = ?";
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
}
