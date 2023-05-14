package cn.llynsyw.java.curriculum.chapter12;

import javax.swing.*;
import java.awt.*;

public class MyBorderLayout {
    public static void main(String[] args) {
        JFrame frm = new JFrame("�߽�ʽ���ֹ�����BorderLayout");
        //�����߽�ʽ���ֹ�����ʵ��border��ˮƽ���Ϊ5����ֱ���Ϊ10
        BorderLayout border = new BorderLayout(5, 10);
        //����frm��ҳ�沼��Ϊborder
        frm.setLayout(border);
        frm.setSize(280,200);
        //�ֱ𴴽����������ť����
        JButton b1=new JButton("��");
        JButton b2=new JButton("��");
        JButton b3=new JButton("��");
        JButton b4=new JButton("��");
        JButton b5=new JButton("��");
        //�����ϰ�ť���뵽frm��
        frm.add(b1,BorderLayout.SOUTH);
        frm.add(b2,BorderLayout.NORTH);
        frm.add(b3,BorderLayout.WEST);
        frm.add(b4,BorderLayout.EAST);
        frm.add(b5,BorderLayout.CENTER);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //����frm�ɼ�
        frm.setVisible(true);
    }
}
