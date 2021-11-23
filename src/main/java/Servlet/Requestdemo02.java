package Servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "Requestdemo02", value = "/Requestdemo02")
public class Requestdemo02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        // 获取请求头数据

        // 获取所有请求头名称
        Enumeration<String> headerNames = request.getHeaderNames();
        //遍历
        while (headerNames.hasMoreElements()){
            String name = headerNames.nextElement();
            // 根据名称获取请求头的值
            String value = request.getHeader(name);
            System.out.println(name+"---"+value);
        }




        // 获取请求头数据user-agent

        String agent = request.getHeader("user-agent");
        // 判断agent的浏览器版本
        if(agent.contains("Chrome")){
            System.out.println("谷歌");
        }else if (agent.contains("Edge")){
            System.out.println("微软");
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
