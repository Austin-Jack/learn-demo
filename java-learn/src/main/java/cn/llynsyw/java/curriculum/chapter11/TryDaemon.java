package cn.llynsyw.java.curriculum.chapter11;

import static java.lang.Thread.sleep;

public class TryDaemon {

    public static void main(String[] args) throws InterruptedException {
        Thread t =new Thread(new DaemonThread());
        //���߳�t����Ϊ�ػ��̣߳���ͨ��setDaemon(true)����
        t.setDaemon(true);
        t.start(); //�����߳�t
        sleep(1); //���̵߳ȴ�1΢��
        System.out.println("main()��������");
    }
}

class DaemonThread implements Runnable  //Runnable�ӿ�ʵ����
{
    @Override
    public void run() {
        while(true)  //��ѭ��
            System.out.println("�߳���������");
    }
}