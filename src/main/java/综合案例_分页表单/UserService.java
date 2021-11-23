package 综合案例_分页表单;


// 用户管理的业务接口

import java.util.List;
import java.util.Map;

public interface UserService {

    // 查询所有用户信息
    List<User> findAll();

    // 登录方法
    User login (User user);

    // 保存User
    void addUser(User user);

    // 删除
    void delete(String id);

    // 根据id查询
    User findUserById(String id);

    void updateUser(User user);

    void delSelect(String[] ids);

    // 记录总查询数
    int findTotalCount(Map<String, String[]> condition);

    // 分页/条件查询每页记录
    List<User> findByPage(int start, int rows, Map<String, String[]> condition);
}
