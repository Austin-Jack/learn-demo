package cn.llynsyw.java.basic.day09.demo01;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
class MyDialog extends  JDialog{
    public  MyDialog(JFrameDemo frame){
        super(frame,"第一个JDialog窗体",true);
        Container container=getContentPane();
        container.add(new JLabel("这是一个对话框"));
        setBounds(200,200,600,800);
    }
}

public class JFrameDemo extends JFrame {
    public void CreateJFrame(String title){
        JFrame jf=new JFrame(title);
        Container container=jf.getContentPane();
        container.setLayout(null);
        jf.setVisible(true);
        JLabel jl=new JLabel("这是我的第一个JFrame窗口");
        jl.setHorizontalAlignment(SwingConstants.CENTER);
        container.add(jl);
        container.setBackground(Color.white);
        jf.setSize(400,300);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JButton bl=new JButton("弹出对话框");
        bl.setBounds(10,10,100,21);
        bl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MyDialog(JFrameDemo.this).setVisible(true);
            }
        });
        container.add(bl);
    }

    public static void main(String[] args) {
        new JFrameDemo().CreateJFrame("Java");
    }
}


