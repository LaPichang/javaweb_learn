package 会话技术;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SessionDemo01_2", value = "/SessionDemo01_2")
public class SessionDemo01_2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 使用session 获取数据‘

        // 获取session
        HttpSession session = request.getSession();
        // 获取数据
        Object msg = session.getAttribute("msg");
        System.out.println(msg);
    }
}
