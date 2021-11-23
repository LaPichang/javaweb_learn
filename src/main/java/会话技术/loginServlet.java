package 会话技术;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "loginServlet", value = "/loginServlet")
public class loginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 设置request编码
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String checkCode = request.getParameter("checkCode");
        // 获取生成的验证码
        HttpSession session = request.getSession();
        String checkCode_session = (String) session.getAttribute("checkCode_session");
        // 删除原有验证码（保证其只能使用一次）
        session.removeAttribute("checkCode_session");
        // 判断验证码是否正确
        if (checkCode_session != null && checkCode_session.equalsIgnoreCase(checkCode)){
            // 判断用户名和密码是否一致
            if("zhangsan".equals(username) && "123".equals(password)){
                // 登录成功,存储用户信息
                session.setAttribute("user",username);
                // 重定向到success.jsp
                response.sendRedirect(request.getContextPath()+"/success.jsp");

            }else {
                // 存储提示信息到request
                request.setAttribute("login_error","用户名或密码错误");
                // 转发到登录页面
                request.getRequestDispatcher("/案例练习_验证码.jsp").forward(request,response);
            }
        }else {
            // 验证码不一致
            // 存储提示信息到request
            request.setAttribute("cc_error","验证码错误");
            // 转发到登录页面
            request.getRequestDispatcher("/案例练习_验证码.jsp").forward(request,response);
        }
    }
}
