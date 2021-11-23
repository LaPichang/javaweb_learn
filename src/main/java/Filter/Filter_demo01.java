package Filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("")
public class Filter_demo01 implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest req = (HttpServletRequest) request;

        // 获取资源请求路径
        String uri = req.getRequestURI();

        // 判断是否包含登录相关资源路径,要注意排除 css/js/图片/验证码等资源
        if (uri.contains("/login.jsp") || uri.contains("/LoginServlet2") || uri.contains("/css/") || uri.contains("/js/") || uri.contains("/fonts/") ||uri.contains("/checkCodeServlet")){
            // 包含，用户目的为登录
            chain.doFilter(request,response);
        }else {
            // 不包含，检验用户是否已经登录
            // 从session 中获取user
            Object user = req.getSession().getAttribute("user");
            if (user != null){
                // 已经登录
                chain.doFilter(request,response);
            }else {
                // 没有登录，跳转到登录页面
                req.setAttribute("login_mag","您尚未登录！");
                req.getRequestDispatcher("/综合案例_分页表单/login.jsp").forward(request,response);
            }
        }
    }
}
