package cn.llynsyw.java.curriculum.chpater14;

import javax.swing.*;
import java.awt.*;

public class PaintShape extends JFrame {
    public PaintShape()
    {
        setTitle("����ͼ��");
        setSize(300,200);
        //������
        JPanel pan= new MyPanel();
        add(pan); //��ӽ�����
        pan.setBounds(0,0,300,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    class MyPanel extends JPanel
    {
        //��дpaintComponent()����
        public void paintComponent(Graphics g)
        {
            g.setColor(Color.black);  //ָ����ɫ�滭
            //���ƿ��ľ���,���Ͻ�����Ϊ(50,50),��Ϊ50,��Ϊ50
            g.drawRect(50,50,50,50);
            //����ʵ�ľ���,���Ͻ�����Ϊ(120,50),��Ϊ50,��Ϊ50
            g.fillRect(120,50,50,50);
            //���ƿ���Բ��,���Ͻ�����Ϊ(50,120),��Ϊ50,��Ϊ50
            g.drawOval(50,120,50,50);
            //����ʵ��Բ��,���Ͻ�����Ϊ(120,120),��Ϊ50,��Ϊ50
            g.fillOval(120,120,50,50);

        }
    }
    //������
    public static void main(String[] args) {
        new PaintShape();
    }

}
