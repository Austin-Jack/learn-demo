package cn.llynsyw.java.basic.summary.demo07;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyThreadPool {
    public static void main(String[] args) {
        //创建线程池对象
        ExecutorService service = Executors.newFixedThreadPool(10);
        //创建Runnable实现类对象
        MyRunnable r = new MyRunnable();

        //从线程池中获取线程对象
        service.submit(r);
        //再提交一些任务
        service.submit(r);
        service.submit(r);
        service.submit(r);

        service.shutdown();
    }

}

class MyRunnable implements Runnable {

    public void run() {
        System.out.println("我要一个教练");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("教练来了:" + Thread.currentThread().getName());
        System.out.println("教我游泳,教完后，教练回到了游泳池");
    }
}

