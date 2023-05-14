package cn.llynsyw.java.curriculum.chapter12;


import javax.swing.*;
import java.awt.*;

public class Windows {
    //������
    public static void main(String[] args) {
        JFrame frm=new JFrame(); //�������frm
        frm.setSize(300,200);//����frm�Ĵ��ڴ�СΪ(300,200)
        frm.setTitle("�ҵĴ���"); //����frm�ı���Ϊ"�ҵĴ���"
        frm.setBackground(Color.red); //��frm�ı�����ɫΪ��ɫ
        frm.setLocation(200,200);//����frm�����Ͻ����Ϊ(200,200)
        Button b=new Button("ȷ��");//������ť�ϵ�����Ϊ"ȷ��"
        frm.add(b);//����ťb��ӵ�frm��
        // ���ùص������ڵ�"�ر�"��ť,��������
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setVisible(true);//��ʾfrm

    }

}
