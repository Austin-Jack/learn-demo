package cn.llynsyw.java.basic.summary.demo07;


class common    //定义同步资源
{
    private char ch;
    private boolean available=false;  //置为false 生产者先运行
    synchronized char get()
    {
        while(available==false)  //当available为false时挂起线程
            try
            {
                wait();  //释放锁，并进入等待状态
            }
            catch (InterruptedException e){}  //异常处理
        available=false;
        notify();  //唤醒对象的其他线程
        return ch;
    }
    synchronized void put(char newch)
    {
        while(available==true)  //当available为true时挂起线程
            try {
                wait(); //释放锁
            }catch (InterruptedException e){}  //异常处理
        ch=newch;
        available=true;
        notify();  //唤醒线程
    }
}
class producer extends Thread  //生产者类继承Thread类
{
    private common comm;
    //构造方法
    public producer(common thiscomm)
    {
        comm=thiscomm;
    }
    public void run()  //重写run()方法
    {
        char c;
        for(c='a';c<='e';c++)
        {
            System.out.println("生产的数据是:"+c);
            comm.put (c);
        }
    }
}

class consumer extends Thread   //消费者类继承Thread类
{
    private common comm;
    //构造方法
    public consumer(common thiscomm)
    {
        comm=thiscomm;
    }
    public void run()   //重写run()方法
    {
        char c;
        for(int i=0;i<5;i++)
        {
            c=comm.get();
            System.out.println("消费者得到的数据是:"+c);
        }
    }
}

public class ProducersToConsumers1     //主程序
{
    public static void main(String[] args) {
        common comm=new common();
        //分别实例化生产者与消费者实例对象
        producer p=new producer(comm);
        consumer c=new consumer(comm);
        //启动线程
        p.start();
        c.start();
    }
}


