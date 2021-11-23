package 综合案例_分页表单.Servlet;

import 综合案例_分页表单.UserService;
import 综合案例_分页表单.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "delSelectServlet", value = "/delSelectServlet")
public class delSelectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String[] ids = request.getParameterValues("uid");
        System.out.println(ids);
        System.out.println(ids.length);
        System.out.println("adasdsadad");
        UserService service = new UserServiceImpl();
        service.delSelect(ids);

        request.getRequestDispatcher("FindUserByPageServlet2").forward(request,response);

    }
}
