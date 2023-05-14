package cn.llynsyw.java.curriculum.chpater14;

import javax.swing.*;
import java.awt.*;

public class PaintFont extends JFrame {  //�̳�JFrame
    PaintFont()
    {
        //��ʼ������
        setTitle("��������");
        setSize(300,200);
        setLayout(null);  //ȡ������
        JPanel pan=new MyPanel();
        add(pan);  //������
        pan.setBounds(0,0,300,200);  //����λ��
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    class MyPanel extends JPanel
    {
        public void paintComponent(Graphics g)
        {
            g.setColor(Color.red);//ָ���ú�ɫ��ͼ
            //ʵ�����������
            Font ft1=new Font("����",Font.PLAIN,25);
            g.setFont(ft1);
            g.drawString("java�������",50,110);
            g.setColor(Color.black);  //ָ���ú�ɫ��ͼ
            //�����������ft2,ʹ��"����"���壬��СΪ30
            Font ft2=new Font("����",Font.BOLD,30);
            g.setFont(ft2);  //ָ����ͼ��ft2
            g.drawString("java�������",50,140);

        }
    }

    //������
    public static void main(String[] args) {
        new PaintFont();
    }
}
