package cn.llynsyw.java.curriculum.chapter13;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Windows2 {
    JFrame f; //���ڶ���
    JLabel lab; //��ǩ
    public void display()
    {
        f=new JFrame("�����¼�2");
        f.setSize(300,200);
        f.setLayout(null); //ȡ������
        lab=new JLabel("�õ�����");
        lab.setBounds(30,20,80,20);
        f.add(lab);
        //Ϊ����fע�ᴰ���¼�ΪWinClose�����
        f.addWindowListener(new WinClose());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    //������
    public static void main(String[] args) {
        (new Windows2()).display();
    }

    class WinClose  extends WindowAdapter  //�̳�WindowAdapter��
    {
        public void windowDeactivated(WindowEvent e) {
            //����ʧȥ����ʱ���ñ�ǩΪʧȥ����
            lab.setText("ʧȥ����");
        }

        public void windowActivated(WindowEvent e) {
            //�����õ�����ʱ���ñ�ǩΪ�õ�����
            lab.setText("�õ�����");
        }
    }
}

