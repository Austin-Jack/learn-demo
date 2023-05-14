package cn.llynsyw.java.basic.summary.demo04;

public class StopThread2 implements Runnable {
    //主方法
    public static void main(String[] args) throws InterruptedException {
        //新建并启动一个线程thread
        Thread thread = new Thread(new StopThread2());
        thread.start();
        Thread.sleep(500);  //主线程等500毫秒
        System.out.println("The Thread thread is "+thread.isInterrupted());
        thread.interrupt();     //给thread线程打上中断标记
        System.out.println("The Thread thread is "+thread.isInterrupted());
    }

    @Override
    public void run() {
        while (true) {
            try {
                //打印是否被标记
                System.out.println("try:"+Thread.currentThread().isInterrupted());
                Thread.sleep(10000);        //当线程被打上标记并被阻塞后会抛出InterruptedException异常
            } catch (InterruptedException e) {   //然后该线程会被catch处理 如果没有退出处理则还会继续
                e.printStackTrace();
                return;
            }
        }
    }
}
