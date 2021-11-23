package 综合案例_分页表单.Servlet;

import 综合案例_分页表单.PageBean;
import 综合案例_分页表单.User;
import 综合案例_分页表单.UserService;
import 综合案例_分页表单.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "FindUserByPageServlet2", value = "/FindUserByPageServlet2")
public class FindUserByPageServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String _currentPage = request.getParameter("currentPage"); // 当前页码
        String _rows = request.getParameter("rows"); // 每页显示条数

        if (_currentPage == null || "".equals(_currentPage)){
            _currentPage = "1";
        }
        if (_rows == null || "".equals(_rows)){
            _rows = "5";
        }

        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);

        if (currentPage <= 0){
            currentPage = 1;
        }


        Map<String,String[]> condition = new HashMap<>();

        UserService service = new UserServiceImpl();

        // 创建空的PageBean对象
        PageBean<User> pb = new PageBean<User>();
        // 设置参数
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);

        // 查询记录总数
        int totalCount = service.findTotalCount(condition);
        pb.setTotalCount(totalCount);
        // 计算开始的记录索引
        int start = (currentPage - 1) * rows;
        List<User> list = service.findByPage(start,rows,condition);
        pb.setList(list);
        // 计算总页码
        int totalPage = (totalCount % rows) == 0 ? totalCount / rows : totalCount / rows + 1;
        pb.setTotalPage(totalPage);

        // 将PageBean 存入request
        request.setAttribute("pb", pb);

        //及那个查询条件存入request
        request.setAttribute("condition",condition);

        // 转发
        request.getRequestDispatcher("/综合案例_分页表单/list.jsp").forward(request, response);
    }
}
