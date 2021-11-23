package Servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/Requestdemo03")
public class Requestdemo03 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get获取请求参数

        // 根据参数名获取参数值
        String username = request.getParameter("username");
        System.out.println("post");
        System.out.println(username);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Post获取请求参数

        request.setCharacterEncoding("utf-8"); //解决中文乱码问题
        // 根据参数名获取参数值
        this.doGet(request,response);
    }
}
