package 综合练习_登录案例;

import org.junit.Test;

public class test {

   @Test
    public void testLogin(){
        User loginuser = new User();
        loginuser.setUsername("WDF");
        loginuser.setPassword("123456");

        UserSQL SQL = new UserSQL();
        User user = SQL.login(loginuser);

        System.out.println(user);
    }
}
