package cn.llynsyw.java.basic.day11.demo04;

/*
    1. 定义Thread类的子类，并重写该类的run()方法，该run()方法的方法体就代表了线程需要完成的任务,因此把run()方法称为线程执行体。
    2. 创建Thread子类的实例，即创建了线程对象
    3. 调用线程对象的start()方法来启动该线程
 */
public class Demo01Thread {
    public static void main(String[] args) {
        MyThread mt=new MyThread("线程0");
        //mt.setName("线程0");
        mt.start();
        for (int i = 0; i < 20; i++) {
            //获取当前线程有两种方式，但在主线程中只能用以下方法，因为没有继承Thread类所有没有getName()方法
            System.out.println(Thread.currentThread().getName()+":"+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}
