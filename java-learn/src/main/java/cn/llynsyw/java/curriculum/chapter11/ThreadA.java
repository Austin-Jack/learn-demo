package cn.llynsyw.java.curriculum.chapter11;

public class ThreadA extends Thread{ //�̳�Thread��
    int count=1;
    int num;
    //���췽��
    public ThreadA(int newNum)
    {
        num=newNum;
        System.out.println("�����߳�"+num);
    }
    //������дrun()����
    public void run()
    {
        while(true)
        {
            System.out.println("�߳�"+num+":����"+count);
            count++;
            if(count==3)  //�������
                break;;
        }
    }

    //������
    public static void main(String[] args) {
        ThreadA a1=new ThreadA(1);//����ThreadA�Ķ���a1,�������1
        ThreadA a2=new ThreadA(2);//����ThreadA�Ķ���a1,�������2
        ThreadA a3=new ThreadA(3);//����ThreadA�Ķ���a1,�������3
        a1.start();//����a1��start()����,�����߳�a1
        a2.start();//����a2��start()����,�����߳�a2
        a3.start();//����a3��start()����,�����߳�a3
        System.out.println("������main()���н���");
    }
}
