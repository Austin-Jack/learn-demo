package cn.llynsyw.java.basic.summary.demo01;
//车票类实现Runnable接口
public class Ticket implements Runnable {
    private int tickerNums=10;

    @Override
    public void run() {
        while (true)
        {
            if(tickerNums<=0){
                break;
            }
            //模拟延时
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //发票并打印输出
            System.out.println(Thread.currentThread() .getName()+"---->得到了第"+tickerNums--+"票");
        }

    }

    public static void main(String[] args) {
        //创建一个对象
        Ticket ticket=new Ticket();

        //创建三个线程并启动
        new Thread(ticket,"小明").start();
        new Thread(ticket,"李华").start();
        new Thread(ticket,"小红").start();
    }
}
