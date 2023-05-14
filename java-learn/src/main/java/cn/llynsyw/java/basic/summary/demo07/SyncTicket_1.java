package cn.llynsyw.java.basic.summary.demo07;

//车票类实现Runnable接口
public class SyncTicket_1 implements Runnable {
    private int tickerNums = 10;

    //创建一个锁对象
    Object object = new Object();

    @Override
    public void run() {
        //同步代码块
        while (true) {
            synchronized (object) {
                if (tickerNums <= 0) {
                    break;
                }
                //模拟延时
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //发票并打印输出
                System.out.println(Thread.currentThread().getName() + "---->得到了第" + tickerNums-- + "票");
            }
        }
    }

    public static void main(String[] args) {
        //创建一个对象
        SyncTicket_1 ticket = new SyncTicket_1();

        //创建三个线程并启动
        new Thread(ticket, "小明").start();
        new Thread(ticket, "李华").start();
        new Thread(ticket, "小红").start();
    }
}
