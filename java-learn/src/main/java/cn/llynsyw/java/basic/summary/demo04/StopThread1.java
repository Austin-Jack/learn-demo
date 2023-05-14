package cn.llynsyw.java.basic.summary.demo04;

public class StopThread1 implements Runnable {
    private boolean isStop=false;
    @Override
    public void run() {
        //根据标志位判断是否继续执行
        while(!isStop){
            System.out.println("The new Tread is running");
            try {
                Thread.sleep(1000000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        System.out.println("The new Thread is Stopped");
    }

    //改变标志位
    void stopNow()
    {
        this.isStop=true;
    }

    //主方法
    public static void main(String[] args) {
        //创建并启动新线程
        StopThread1 t1=new StopThread1();
        new Thread(t1).start();

        for (int i = 0; i < 10000; i++) {
            System.out.println("The main Thread is running");
        }
        t1.stopNow();

    }
}


