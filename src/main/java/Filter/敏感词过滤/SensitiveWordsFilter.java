package Filter.敏感词过滤;


import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

@WebFilter("/SensitiveWordsServlet")
public class SensitiveWordsFilter implements Filter {

    // 敏感词汇集合
    private List<String> list = new ArrayList<>();
    public void init(FilterConfig config) throws ServletException {


        try {
            // 加载文件
            ServletContext servletContext = config.getServletContext();
            String realPath = servletContext.getRealPath("/Filter/敏感词过滤/敏感词.txt");

            // 读取文件
            BufferedReader br = new BufferedReader(new FileReader(realPath));

            // 将文件的每一行数据添加到list中
            String line = null;
            while((line = br.readLine()) != null){
                list.add(line);
                System.out.println(".asd..a.sd.");
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        ServletRequest proxy_req = (ServletRequest) Proxy.newProxyInstance(request.getClass().getClassLoader(), request.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                // 增强getParameter 方法
                if(method.getName().equals("getParameter")){
                    // 增强返回值
                    String value = (String) method.invoke(request, args);
                    if(value != null){
                        for (String s : list) {
                            if (value.contains(s)){
                                value = value.replaceAll(s,"***");
                            }
                        }
                    }
                    return value;
                }
                return null;
            }
        });


        chain.doFilter(request, response);
    }
}
