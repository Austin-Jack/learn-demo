package cn.llynsyw.java.basic.day12.demo01;

public class Demo01Lambda {
    public static void main(String[] args) {
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"线程被创建了");
        }).start();
    }
}
