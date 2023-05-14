package cn.llynsyw.java.basic.summary.demo05;

class TestThread implements Runnable{//实现 Runnable 接口
    public void run(){//覆写 Thread 类中的 run() 方法
        for(int i=0;i<3;i++){
            System.out.println(Thread.currentThread().getName()
                    + "运行 --> " + i);//取得当前线程的名称
            if(i==1){
                System.out.println("线程礼让：" );
                Thread.currentThread().yield();//线程礼让
            }
        }
    }
}

public class Comity {
    public static void main(String[] args) {
        TestThread my = new TestThread();//定义 Runnable 子类对象
        Thread t1 = new Thread(my, "线程 A");//实例化 Thread 对象
        Thread t2 = new Thread(my, "线程 B");//实例化 Thread 对象
        t1.start();//启动线程
        t2.start();//启动线程
    }
}