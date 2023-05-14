package cn.llynsyw.java.curriculum.chapter13;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Windows1 {
    JFrame f; //���ڶ���
    JLabel lab; //��ǩ
    public void display()
    {
        f=new JFrame("�����¼�1");
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
        (new Windows1()).display();
    }

    class WinClose implements WindowListener  //ʵ��WindowListener�ӿ�
    {
        //ʵ��WindowListener�ӿ��еĳ��󷽷�
        public void windowOpened(WindowEvent e) {}
        public void windowClosing(WindowEvent e) {}
        public void windowClosed(WindowEvent e) {}
        public void windowIconified(WindowEvent e) {}
        public void windowDeiconified(WindowEvent e) {}
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

