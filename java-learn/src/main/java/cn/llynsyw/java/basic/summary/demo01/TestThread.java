package cn.llynsyw.java.basic.summary.demo01;

//继承Thread类
public class TestThread extends Thread {
    //必须重写run方法
    @Override
    public void run() {
        for (int i=0;i<200;i++)
        {
            System.out.println("-----Thread1------");
        }
    }
    /*主方法*/
    public static void main(String[] args) {

        //创建一个线程对象
        TestThread t1=new TestThread();

        //创建调用start()方法开启线程
        t1.start();

        for (int i=0;i<2000;i++)
        {
            System.out.println("-----main------");
        }
    }
}
