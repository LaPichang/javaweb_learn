package 综合案例_分页表单.Servlet;

import 综合案例_分页表单.UserService;
import 综合案例_分页表单.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "deleteUserServlet", value = "/deleteUserServlet")
public class deleteUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.获取id
        String id = request.getParameter("id");
        //2.调用service删除
        UserService service = new UserServiceImpl();
        service.delete(id);

        //3.跳转到查询所有Servlet
        request.getRequestDispatcher("FindUserByPageServlet2").forward(request,response);
    }
}
