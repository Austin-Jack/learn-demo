package cn.llynsyw.java.curriculum.chapter13;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Copy implements ActionListener {  //ʵ��ActionListener�ӿ�
    JButton b; //��ť
    JTextField L, R; //�����ı���

    public void display() {
        JFrame f = new JFrame("����"); //������
        f.setSize(400, 150);//��СΪ400*150
        f.getContentPane().setBackground(Color.lightGray);//����Ϊ����ɫ
        f.setLayout(new FlowLayout());  //���ò���Ϊ������
        L = new JTextField(10); //ʵ�����ı���
        R = new JTextField(10);
        b = new JButton("����");  //ʵ������ť
        f.add(L);
        f.add(b);
        f.add(R);
        //Ϊ��ťb��ע���¼�������ΪCopy����
        b.addActionListener(this);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b)
            R.setText(L.getText()); //������ı�������ݸ��Ƶ��ұ�
    }

    //������
    public static void main(String[] args) {

        (new Copy()).display();     //����Copy�������󲢵���display()
    }

}
