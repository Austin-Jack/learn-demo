package cn.llynsyw.java.basic.summary.demo05;

class MyThread implements Runnable{//实现 Runnable 接口
    public void run(){//覆写 Thread 类中的 run() 方法
        for(int i=0;i<3;i++){
            try{
                Thread.sleep(2);
            }catch (Exception e){}
            System.out.println(Thread.currentThread().getName()
                    + "运行 --> " + i);//取得当前线程的名称
        }
    }
}

public class Priority{
    public static void main(String[] args) {
        MyThread my = new MyThread();//定义 Runnable 子类对象
        Thread t1 = new Thread(my,"线程 A");//实例化 Thread 对象
        Thread t2 = new Thread(my,"线程 B");//实例化 Thread 对象
        Thread t3 = new Thread(my,"线程 C");//实例化 Thread 对象
        t1.setPriority(Thread.MIN_PRIORITY);//设置线程A优先级为最低
        t2.setPriority(Thread.MAX_PRIORITY);//设置线程B优先级为最高
        t3.setPriority(Thread.NORM_PRIORITY);//设置线C程优先级为中等
        t1.start();//启动线程
        t2.start();//启动线程
        t3.start();//启动线程
    }
}
