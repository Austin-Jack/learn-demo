package cn.llynsyw.java.basic.day11.demo06;

public class ThreadSafety {
    public static void main(String[] args) {
        Demo03Lock sy=new Demo03Lock();
        Thread t=new Thread(sy);
        Thread t2=new Thread(sy);
        Thread t3=new Thread(sy);
        t.start();
        t2.start();
        t3.start();
    }
}
