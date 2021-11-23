package Proxy动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class proxy {

    public static void main(String[] args) {

        Lenovo lenovo = new Lenovo();


        /**
         * 利用代理对象增强真实对象
         *
         *
         * 参数：
         * 1、类加载器：真实对象.getClass().getClassLoader()
         * 2、接口数组：真实对象.getClass().getInterfaces()
         * 3、处理器：new InvocationHandler()
         */
        SaleComputer proxy_lenovo = (SaleComputer) Proxy.newProxyInstance(lenovo.getClass().getClassLoader(), lenovo.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                /**
                 * 代理逻辑编写的方法，代理对象调用的所有方法都会出发该方法的执行
                 * 参数
                 * 1、proxy: 代理对象
                 * 2、method: 代理对象调用的方法，被封装为对象
                 * 3、args: 代理对象调用方法时，传递的实际参数
                 */

                // 判断是不是sale方法
                if(method.getName().equals("sale")){
                    double money = (double) args[0];
                    money = money * 0.85;
                    // 使用真实对象调用该方法
                    Object obj = method.invoke(lenovo, args);
                    return obj + "_鼠标垫";
                }else {
                    Object obj = method.invoke(lenovo, args);
                    return obj;
                }

            }
        });


        String computer = proxy_lenovo.sale(8000);
        System.out.println(computer);

        //proxy_lenovo.show();
    }
}
