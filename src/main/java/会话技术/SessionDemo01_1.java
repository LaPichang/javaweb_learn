package 会话技术;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SessionDemo01_1", value = "/SessionDemo01_1")
public class SessionDemo01_1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 使用session共享数据
        HttpSession session = request.getSession();
        // 存储数据
        session.setAttribute("msg","hello session");
    }
}
