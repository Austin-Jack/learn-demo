package cn.llynsyw.java.curriculum.chapter11;

public class Sale {

    public static void main(String[] args) {
        SaleTickets t=new SaleTickets();
        //�ֱ𴴽�4���̣߳����������t������������
        Thread t1=new Thread(t);
        Thread t2=new Thread(t);
        Thread t3=new Thread(t);
        Thread t4=new Thread(t);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
class SaleTickets implements Runnable
{
    private int tickets=1;
    //������дrun()����
    public void run()
    {
        while(true)
        {
            //����߳����ֺ�������Ʊ00
            if(tickets<=100)
                System.out.println(Thread.currentThread().getName()+
                        "���۵�"+tickets++ +"Ʊ");
            else  //����100��
                break;
        }
    }
}

