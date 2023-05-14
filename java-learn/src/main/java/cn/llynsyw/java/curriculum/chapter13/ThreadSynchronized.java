package cn.llynsyw.java.curriculum.chapter13;

class common    //����ͬ����Դ
{
    private char ch;
    private boolean available=false;  //��Ϊfalse ������������
    synchronized char get()
    {
        while(available==false)  //��availableΪfalseʱ�����߳�
        try
        {
            wait();  //�ͷ�����������ȴ�״̬
        }
        catch (InterruptedException e){}  //�쳣����
        available=false;
        notify();  //���Ѷ���������߳�
        return ch;
    }
    synchronized void put(char newch)
    {
        while(available==true)  //��availableΪtrueʱ�����߳�
            try {
                wait(); //�ͷ���
            }catch (InterruptedException e){}  //�쳣����
        ch=newch;
        available=true;
        notify();  //�����߳�
    }
}
class producer extends Thread  //��������̳�Thread��
{
    private common comm;
    //���췽��
    public producer(common thiscomm)
    {
        comm=thiscomm;
    }
    public void run()  //��дrun()����
    {
        char c;
        for(c='a';c<='e';c++)
        {
            System.out.println("������������:"+c);
            comm.put (c);
        }
    }
}

class consumer extends Thread   //��������̳�Thread��
{
    private common comm;
    //���췽��
    public consumer(common thiscomm)
    {
        comm=thiscomm;
    }
    public void run()   //��дrun()����
    {
        char c;
        for(int i=0;i<5;i++)
        {
            c=comm.get();
            System.out.println("�����ߵõ���������:"+c);
        }
    }
}

public class ThreadSynchronized     //������
{
    public static void main(String[] args) {
        common comm=new common();
        //�ֱ�ʵ������������������ʵ������
        producer p=new producer(comm);
        consumer c=new consumer(comm);
        //�����߳�
        p.start();
        c.start();
    }
}

