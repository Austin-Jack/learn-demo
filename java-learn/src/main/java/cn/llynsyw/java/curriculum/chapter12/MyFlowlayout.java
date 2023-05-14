package cn.llynsyw.java.curriculum.chapter12;

import javax.swing.*;
import java.awt.*;

public class MyFlowlayout extends JFrame {
    //����MyFlowLayout��Ĺ��췽��
    MyFlowlayout(String title)
    {
        super(title);
    }

    public static void main(String[] args) {
        //ʵ����MyFlowLayout��
        MyFlowlayout frm=new MyFlowlayout("��ʽ���ֹ�����FlowLayout");
        //������ʽ���ֹ�������һ��ʵ��flow,ָ�����뷽ʽΪ���ж���
        FlowLayout flow=new FlowLayout(FlowLayout.CENTER);

        //��������������ť����
        JButton b1=new JButton("��һ����ť");
        JButton b2=new JButton("�ڶ�����ť");
        JButton b3=new JButton("��������ť");

        frm.setLayout(flow);//����frm��ҳ�沼��Ϊflow
        frm.setSize(200,150);
        //���ñ�����ɫΪ��ɫ
        frm.getContentPane().setBackground(Color.PINK);
        //��������ť��ӵ����frm��
        frm.add(b1);
        frm.add(b2);
        frm.add(b3);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //���ÿɼ�
        frm.setVisible(true);

    }
}
