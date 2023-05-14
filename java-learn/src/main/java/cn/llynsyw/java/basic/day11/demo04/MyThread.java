package cn.llynsyw.java.basic.day11.demo04;

public class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }

    public MyThread() {
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(getName()+":"+i);
        }
    }
}
