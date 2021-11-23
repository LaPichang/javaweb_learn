package JQuery案例.综合案例;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "JQueryregistServlet", value = "/JQueryregistServlet")
public class JQueryregistServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        response.setContentType("text/html;charset=utf-8");

        // 获取用户名
        String username = request.getParameter("username");

        // 调用service 判断用户名是否存在

        Map<String, Object> map = new HashMap<>();

        if ("tom".equals(username)) {
            // 存在
            map.put("userExist", true);
            map.put("msg", "此用户名太受欢迎，请更换一个");
        } else {
            // 不存在
            map.put("userExist",false);
            map.put("msg","用户名可用");
        }

        // 将map 转为json，并传递给客户端
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getWriter(),map);

    }
}
