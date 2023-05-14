package cn.llynsyw.java.basic.day11.demo06;

public class Demo01Synchronized implements Runnable {
    private int counts = 10;
    Object obj=new Object();

    @Override
    public void run() {
        synchronized (obj) {
            while (true) {
//                if (counts > 0) {
//                    System.out.println(Thread.currentThread().getName() + "-->" + counts);
//                    counts--;
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
                synchronizedMethod();
            }
        }
    }

    private synchronized void synchronizedMethod() {
        if (counts > 0) {
            System.out.println(Thread.currentThread().getName() + "-->" + counts);
            counts--;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
