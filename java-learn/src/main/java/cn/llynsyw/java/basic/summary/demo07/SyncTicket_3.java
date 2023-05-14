package cn.llynsyw.java.basic.summary.demo07;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//车票类实现Runnable接口
public class SyncTicket_3 implements Runnable {
    private int tickerNums = 10;

    //创建一个锁
    Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            lock.lock();    //上锁
            if (tickerNums <= 0) {
            lock.unlock();         //退出线程时手动释放锁，不同于synchronized线程执行完后不会自动释放锁
                break;
            }
            //模拟延时
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();  //保证本次释放锁
            }
            //发票并打印输出
            System.out.println(Thread.currentThread().getName() + "---->得到了第" + tickerNums-- + "票");
        }
    }

    public static void main(String[] args) {
        //创建一个对象
        SyncTicket_3 ticket = new SyncTicket_3();

        //创建三个线程并启动
        new Thread(ticket, "小明").start();
        new Thread(ticket, "李华").start();
        new Thread(ticket, "小红").start();
    }
}
