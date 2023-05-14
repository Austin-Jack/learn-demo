package cn.llynsyw.java.curriculum.chpater14;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Enumeration;
import java.util.Vector;

class MyOval  //�Զ�����Բ��
{
    private int x; //���Ͻ�x
    private int y;  //���Ͻ�y
    private int width; //���
    private int height;//�߶�
    //���췽��
    public MyOval(int newX,int newY,int newWidth,int newHeight)
    {
        x=newX;
        y=newY;
        width=newWidth;
        height=newHeight;
    }
    //������Բ
    public void drawMe(Graphics g)
    {
        //�滭��Բ
        g.drawOval(x,y,width,height);
    }
}

public class RedrawOval extends JFrame {
    //����
    Vector<MyOval> vOvals=new Vector<MyOval>();

    public static void main(String[] args) {
        RedrawOval f=new RedrawOval();
        f.init();
    }
    public void init()
    {
        setTitle("�ػ�ͼ��");
        setSize(300,300);
        //���������������
        JPanel pan=new MyPanel();
        add(pan);
        pan.setBounds(0,0,300,300);
        //Ϊ���ע�������������ʵ��

        pan.addMouseListener(new MouseAdapter() {
            int orgX; //��갴��ʱ������
            int orgY;
            @Override
            public void mousePressed(MouseEvent e) {
                //��갴�¼�¼λ��
                orgX=e.getX();
                orgY=e.getY();
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                //����ɿ�ʱ
                Graphics g=e.getComponent().getGraphics();//��ȡ��������
                g.setColor(Color.red);//ָ���ú�ɫ����
                g.drawOval(orgX,orgY,e.getX()-orgX,e.getY()-orgY);//������Բ

                //������������µ�MyOval����
                vOvals.add(new MyOval(orgX,orgY,e.getX()-orgX,e.getY()-orgY));
            }
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }
    class MyPanel extends JPanel  //�����
    {
        //��дpaintComponent()����
        public void paintComponent(Graphics g)
        {
            g.setColor(Color.red);//ָ���ú�ɫ����
            Enumeration e=vOvals.elements();
            while(e.hasMoreElements()) //���µ���Բ����ʱ
            {
                MyOval ln=(MyOval)e.nextElement();//��ȡ���µĶ���
                ln.drawMe(g);// �������
            }
        }

    }
}
