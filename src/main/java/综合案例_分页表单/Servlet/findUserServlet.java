package 综合案例_分页表单.Servlet;

import 综合案例_分页表单.User;
import 综合案例_分页表单.UserService;
import 综合案例_分页表单.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "findUserServlet", value = "/findUserServlet")
public class findUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 获取id
        String id = request.getParameter("id");
        // 调用Servlet查询
        UserService service = new UserServiceImpl();
        User user = service.findUserById(id);

        // 将user 存入request
        request.setAttribute("user",user);
        // 转发到update.jsp
        request.getRequestDispatcher("/综合案例_分页表单/update.jsp").forward(request,response);
    }
}
