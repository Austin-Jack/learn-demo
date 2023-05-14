package cn.llynsyw.java.curriculum.chapter13;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Student implements ActionListener, ItemListener {
    JFrame f; //���ڶ���
    JTextField number,name; //�ı���
    JComboBox dept,major; //��Ͽ�
    List infor;   //�б��
    JRadioButton sex1,sex2; //�Ա�ѡ��ť
    JButton addInfor,deleteInfor; //��ť

    public static void main(String[] args) {
        (new Student()).display();
    }
    public void display()
    {
        JPanel p1,p2,p3;//���
        ButtonGroup cg; //��ť��
        f=new JFrame("ѧ����Ϣ���봰��"); //ʵ��������
        f.setSize(480,200);
        f.getContentPane().setBackground(Color.lightGray);
        //���񲼾֣����ҷָ��
        f.setLayout(new GridLayout(1,2));
        infor=new List();  //�����б��
        f.add(infor); //ռ�ݴ�����벿��
        p1=new JPanel();
        //���񲼾֣�6��1��
        p1.setLayout(new GridLayout(6,1));
        f.add(p1);
        number=new JTextField("ѧ��:");  //�������
        name=new JTextField("����:");
        cg=new ButtonGroup();
        sex1=new JRadioButton("��",true);
        sex2=new JRadioButton("Ů",false);
        cg.add(sex1);  //���Ա�ť����ͬһ����
        cg.add(sex2);
        dept=new JComboBox();  //����ѡ���
        dept.addItem("�����ϵ");
        dept.addItem("����ϵ");
        dept.addItemListener(this); //ע��ѡ����¼�������
        major=new JComboBox();
        major.addItem("��������ѧ����");
        major.addItem("��Ϣ��������Ϣϵͳ");
        addInfor=new JButton("����");
        deleteInfor=new JButton("ɾ��");
        //Ϊ��ť���ע���¼�������
        addInfor.addActionListener(this);
        deleteInfor.addActionListener(this);
        //���������ӵ����P1��
        p1.add(number);
        p1.add(name);
        p2=new JPanel();
        //���񲼾֣�һ������
        p2.setLayout(new GridLayout(1,2));
        p2.add(sex1);
        p2.add(sex2);
        p1.add(p2); //��p1��������p2
        p1.add(dept);
        p1.add(major);
        p3=new JPanel();
        p3.setLayout(new GridLayout(1,2));
        p3.add(addInfor);
        p3.add(deleteInfor);
        p1.add(p3);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

    }
    //�¼�������
    public void actionPerformed(ActionEvent e)
    {
        //��ѡ��ťѡ��ʱ,��ӱ�ǩ
        if(e.getSource()==addInfor)
        {
            String str;
            str=number.getText()+""+name.getText();

            if(sex1.isSelected())
                str=str+" "+sex1.getText();
            if(sex2.isSelected())
                str=str+" "+sex1.getText();
            //���ѡ����ѡ����
            str=str+" "+dept.getSelectedItem();
            str=str+" "+major.getSelectedItem();
            infor.add(str);   //����б��ѡ��
        }
        //����ɾ����ťʱ
        if(e.getSource()==deleteInfor)
        {
            if(infor.getSelectedIndex()>=0)  //����ѡ�ѡ��
                infor.remove((infor.getSelectedIndex()));
        }
    }

    public void itemStateChanged(ItemEvent e)
    {
        if(dept.getSelectedIndex()==0)
        {
            major.removeAllItems(); //���ѡ���major
            major.addItem("�������ѧ�뼼��");
            major.addItem("��Ϣ��������Ϣϵͳ");
        }
        if(dept.getSelectedIndex()==1)
        {
            major.removeAllItems(); //���ѡ���major
            major.addItem("���ʽ���");
            major.addItem("�������");
        }
    }

}

