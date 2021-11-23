package Jedis.综合案例;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProvinceServlet", value = "/ProvinceServlet")
public class ProvinceServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

       /* // 调用 service 查询
        ProvinceService service = new ProvinceServiceImpl();
        List<Province> list = service.findAll();
        // 序列化list 为json
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(list);*/

        System.out.println("asdasda");
        // 调用 service 查询
        ProvinceService service = new ProvinceServiceImpl();
        String json = service.findAllJson();

        // 响应结果
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json);
    }
}
