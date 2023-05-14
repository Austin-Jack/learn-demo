package cn.llynsyw.java.basic.day11.demo04;

public class Demo02Runnable {
    public static void main(String[] args) {
        RunnableImp run=new RunnableImp();
        Thread t0=new Thread(run);
        t0.start();
    }
}
