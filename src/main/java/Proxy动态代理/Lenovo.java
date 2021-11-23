package Proxy动态代理;

public class Lenovo implements SaleComputer{
    @Override
    public String sale(double money) {

        System.out.println("电脑卖了" + money + "钱");
        return "联想电脑";
    }

    @Override
    public void show() {

        System.out.println("展示电脑");
    }
}
