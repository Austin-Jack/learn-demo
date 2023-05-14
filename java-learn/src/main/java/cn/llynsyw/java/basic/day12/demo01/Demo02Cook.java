package cn.llynsyw.java.basic.day12.demo01;

public class Demo02Cook {
    public static void main(String[] args) {
        invoke(()->{
            System.out.println("吃饭了");
        });
    }

    public static void invoke(Cook cook){
        cook.makeFood();
    }
}
