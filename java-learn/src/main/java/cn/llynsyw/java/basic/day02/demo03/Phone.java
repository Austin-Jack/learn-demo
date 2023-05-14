package cn.llynsyw.java.basic.day02.demo03;

/*
类的声明
 */
public class Phone {
    String brand;//品牌
    int price;//价格
    String color;//颜色

    public void call(String who) {
        System.out.println("给" + who + "打电话");
    }

    public void sendMessage(String who) {
        System.out.println("给" + who + "发短信");

    }
}
