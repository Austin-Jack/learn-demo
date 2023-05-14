package cn.llynsyw.java.curriculum.chapter12;

import javax.swing.*;
import java.awt.*;


public class MyGridLayout {
    //������
    public static void main(String[] args) {
        JFrame frm=new JFrame("����ʽ���ֹ�����");
        frm.setSize(300,200);
        //��������ʽ���ֹ�������һ��ʵ��grid�����Ϊ3��3��
        GridLayout grid=new GridLayout(3,3);
        //����frm��ҳ�沼��Ϊgrid
        frm.setLayout(grid);
        //����һ������ΪJButton������b�����鳤��Ϊ9
        JButton b[]=new JButton[9];
        //���ν�ʵ�����İ�ť��ӵ�frm��
        for (int i = 0; i < 9; i++) {
            b[i]=new JButton(i+1+"");
            frm.add(b[i]);
        }
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setVisible(true);
    }
}
