package 综合案例_分页表单.Servlet;

import org.apache.commons.beanutils.BeanUtils;
import 综合案例_分页表单.User;
import 综合案例_分页表单.UserService;
import 综合案例_分页表单.UserServiceImpl;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet(name = "LoginServlet2", value = "/LoginServlet2")
public class LoginServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 设置request编码
        request.setCharacterEncoding("utf-8");

        String checkCode = request.getParameter("checkCode");

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
        UserService DAO = new UserServiceImpl();
        User user = DAO.login(loginuser);
        // 获取生成的验证码
        HttpSession session = request.getSession();
        String checkCode_session = (String) session.getAttribute("checkCode_session");
        // 删除原有验证码（保证其只能使用一次）
        session.removeAttribute("checkCode_session");
        // 判断验证码是否正确
        if (checkCode_session != null && checkCode_session.equalsIgnoreCase(checkCode)){
            // 判断用户名和密码是否一致
            // 判断user
            if (user == null){
                // 登录失败
                // 存储提示信息到request
                request.setAttribute("login_error","用户名或密码错误");
                request.getRequestDispatcher("/综合案例_分页表单/login.jsp").forward(request,response);
            }else {
                // 登录成功
                // 存储数据
                request.setAttribute("user",user);
                // 转发
                request.getRequestDispatcher("/综合案例_分页表单/index.jsp").forward(request,response);
            }
        }else {
            // 验证码不一致
            // 存储提示信息到request
            request.setAttribute("cc_error","验证码错误");
            // 转发到登录页面
            request.getRequestDispatcher("/综合案例_分页表单/login.jsp").forward(request,response);
        }
    }
}
