package Servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;


// 直接创建 Servlet文件
@WebServlet("/Requestdemo01")
public class Requestdemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        //获取请求行数据



        // 获取请求方式：Get
        String method = request.getMethod();
        System.out.println(method);
        // 获取虚拟目录
        String contextPath = request.getContextPath();
        System.out.println(contextPath);
        // 获取Servlet路径
        String servletPath = request.getServletPath();
        System.out.println(servletPath);
        // 获取get方式请求参数
        String queryString = request.getQueryString();
        System.out.println(queryString);
        // 获取请求URL
        String requestURI = request.getRequestURI();
        StringBuffer requestURL = request.getRequestURL();
        System.out.println(requestURI);
        System.out.println(requestURL);
        // 获取协议及版本
        String protocol = request.getProtocol();
        System.out.println(protocol);
        // 获取客户机的IP地址
        String remoteAddr = request.getRemoteAddr();
        System.out.println(remoteAddr);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
