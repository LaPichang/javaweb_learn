package Servlet;

import javax.servlet.*;
import java.io.IOException;

public class Servletdemo01 implements Servlet {


    /**
     * 初始化方法，在Servlet被创建时，只会执行一次
     * @param servletConfig
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }


    /**
     * 提供服务的方法，每一次Servlet被访问时都会执行
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Hello Servlet");
    }

    @Override
    public String getServletInfo() {
        return null;
    }


    /**
     * 销毁方法，在服务器被正常关闭时，执行一次
     */
    @Override
    public void destroy() {

    }
}
