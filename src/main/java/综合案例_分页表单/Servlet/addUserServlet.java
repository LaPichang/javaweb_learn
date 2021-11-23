package 综合案例_分页表单.Servlet;

import org.apache.commons.beanutils.BeanUtils;
import 综合案例_分页表单.User;
import 综合案例_分页表单.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet(name = "addUserServlet", value = "/addUserServlet")
public class addUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        // 获取参数
        Map<String, String[]> map = request.getParameterMap();
        // 封装对象
        User user = new User();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        // 调用Service保存
        UserServiceImpl userService = new UserServiceImpl();
        userService.addUser(user);

        // 跳转到userListServlet
        request.getRequestDispatcher("FindUserByPageServlet2").forward(request,response);
    }
}
