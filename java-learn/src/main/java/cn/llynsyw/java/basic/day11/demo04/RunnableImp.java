package cn.llynsyw.java.basic.day11.demo04;

public class RunnableImp implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
