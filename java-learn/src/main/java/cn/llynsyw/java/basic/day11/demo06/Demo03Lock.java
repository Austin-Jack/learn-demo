package cn.llynsyw.java.basic.day11.demo06;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Demo03Lock implements Runnable {
    private int counts = 10;

    Lock l = new ReentrantLock();


    @Override
    public void run() {
        while (true) {
            l.lock();//获取锁
            if (counts > 0) {
                System.out.println(Thread.currentThread().getName() + "-->" + counts);
                counts--;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    l.unlock();//释放锁
                }
            }

        }

    }
}
