package cn.llynsyw.java.curriculum.chapter11;

public class ThreadB implements Runnable { //ʵ��Runnable�ӿ�
    int count = 1;
    int num;

    public ThreadB(int newNum) {
        num = newNum;
        System.out.println("�����߳�" + num);
    }
    //������дrun()����
    public void run()
    {
        while(true){

            System.out.println("�߳�"+num+":����"+count);
            count++;
            if(count==3)    //�������
                break;
        }
    }
    //������
    public static void main(String[] args) {
        //����Thread�Ķ���a1,�������new ThreadB(1)
        Thread a1=new Thread(new ThreadB(1));
        //����Thread�Ķ���a2,�������new ThreadB(2)
        Thread a2=new Thread(new ThreadB(2));
        //����Thread�Ķ���a3,�������new ThreadB(3)
        Thread a3=new Thread(new ThreadB(3));
        a1.start();//����a1��start()����,�����߳�a1
        a2.start();//����a2��start()����,�����߳�a2
        a3.start();//����a3��start()����,�����߳�a3
        System.out.println("������main()���н���");
    }

}
