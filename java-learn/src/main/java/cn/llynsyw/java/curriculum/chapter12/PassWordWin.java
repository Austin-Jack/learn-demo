package cn.llynsyw.java.curriculum.chapter12;

import javax.swing.*;
import java.awt.*;

public class PassWordWin extends JFrame {
    public static void main(String[] args) {
        //����PassWordWin���ʵ��frm
        PassWordWin frm=new PassWordWin();
        frm.setSize(300,200);
        //���ô��ڱ���Ϊ"������֤"
        frm.setTitle("������֤");
        //����frm�ı�����ɫΪRGB(200,200,255)
        frm.getContentPane().setBackground(new Color(200,200,255));
        //ȡ��frm�Ĳ��ֹ�����
        frm.setLayout(null);

        //����"�û���:"��ǩ
        JLabel L1=new JLabel("�û���:");
        L1.setBounds(40,50,55,20);
        //�����ı���
        JTextField t1=new JTextField(50);
        t1.setBounds(100,50,100,20);

        //���������ǩ
        JLabel L2=new JLabel("����:");
        L2.setBounds(40,80,55,20);
        //���������ı������������ı���Ļ��Է�Ϊ��*��
        JPasswordField t2=new JPasswordField(50);
        t2.setEchoChar('*');
        t2.setBounds(100,80,100,20);

        //����"ȷ��"��ť
        JButton btn=new JButton("ȷ��");
        btn.setBounds(70,110,100,30);
        //�������ӵ�frm��
        frm.add(t1);
        frm.add(L1);
        frm.add(L2);
        frm.add(t2);
        frm.add(btn);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setVisible(true);

    }
}
