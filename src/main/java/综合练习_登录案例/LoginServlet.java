package 综合练习_登录案例;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 设置编码
        request.setCharacterEncoding("utf-8");
        // 获取请求参数
        /**
         * String username = request.getParameter("username");
         * String password = request.getParameter("password");
        // 封装User对象
        User loginuser = new User();
        loginuser.setUsername(username);
        loginuser.setPassword(password);
         */


        // 用BeanUtils工具类优化
        // 获取请求参数
        Map<String, String[]> map = request.getParameterMap();
        // 创建User对象
        User loginuser = new User();
        // 使用BeanUtils封装
        try {
            BeanUtils.populate(loginuser,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        // 调用UserSQL的Login方法
        UserSQL SQL = new UserSQL();
        User user = SQL.login(loginuser);

        // 判断user
        if (user == null){
            // 登录失败
            //request.getRequestDispatcher("/Failservlet").forward(request,response);
            request.getRequestDispatcher("/fail.html").forward(request,response);
        }else {
            // 登录成功
            // 存储数据
            request.setAttribute("user",user);
            // 转发
            //request.getRequestDispatcher("/SuccessServlet").forward(request,response);
            request.getRequestDispatcher("/Success.html").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
