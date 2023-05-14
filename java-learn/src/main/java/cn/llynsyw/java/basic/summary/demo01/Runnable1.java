package cn.llynsyw.java.basic.summary.demo01;
//实现Runnable接口
public class Runnable1 implements Runnable {
    //必须重写run方法
    @Override
    public void run() {
        for (int i=0;i<200;i++)
        {
            System.out.println("-----Thread1------");
        }
    }

    //主方法
    public static void main(String[] args) {

    //Runnable1 runnable1=new Runnable1();
    //Thread t1=new Thread(runnable1);
    //t1.start();

        //创建一个线程使用Thread类代理调用start()方法启动线程
        new Thread(new Runnable1()).start();

        for (int i=0;i<2000;i++)
        {
            System.out.println("-----main------");
        }
    }
}
