package cn.llynsyw.java.basic.summary.demo07;

//车票类实现Runnable接口
public class SyncTicket_2 implements Runnable {
    private int tickerNums = 10;

    @Override
    public void run() {
        boolean isRemain=true;     //标识是否还剩余票
        while (isRemain) {
               isRemain=sell();
        }
    }

    //定义一个同步方法
    public synchronized boolean sell() {
        if (tickerNums <= 0) {
            return false;
        }
        //模拟延时
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //发票并打印输出
        System.out.println(Thread.currentThread().getName() + "---->得到了第" + tickerNums-- + "票");
        return true;
    }

    public static void main(String[] args) {
        //创建一个对象
        SyncTicket_2 ticket = new SyncTicket_2();

        //创建三个线程并启动
        new Thread(ticket, "小明").start();
        new Thread(ticket, "李华").start();
        new Thread(ticket, "小红").start();
    }
}
