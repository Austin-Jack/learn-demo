package cn.llynsyw.java.curriculum.chpater14;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PaintLine {
    JFrame f=new JFrame("����ֱ��");
    //���ڳ�ʼ������
    public void init()
    {
        f.setTitle("����ֱ��");
        f.setSize(300,200);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        f.addMouseListener(new MouseAdapter() {  //ע������¼�������
            int x1;
            int y1;
            int x2;
            int y2;
            @Override
            public void mousePressed(MouseEvent e) {
                //��갴��,����ǰ����ֱ�ֵ��x1,y1
                x1= e.getX();
                y1= e.getY();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                //����ɿ�,����ǰ����ֱ�ֵ��x2,y2
                x2= e.getX();
                y2= e.getY();
                //��õ�ǰ����Graphics�Ķ��󲢸�ֵ��g
                Graphics g=e.getComponent().getGraphics();
                //����g�Ļ�����ɫΪ��ɫ
                g.setColor(Color.red);
                //����ֱ��,�ӵ�(x1,y1)����(x2,y2)
                g.drawLine(x1,y1,x2,y2);

            }
        });

        //������
    }

    public static void main(String[] args) {
        (new PaintLine()).init();
    }
}
