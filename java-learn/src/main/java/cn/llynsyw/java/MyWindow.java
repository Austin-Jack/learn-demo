package cn.llynsyw.java;

import javax.swing.*;
import java.awt.*;

public class MyWindow {
    public static void main(String[] args) {
        JFrame frm=new JFrame();
        frm.setSize(300,200);
        frm.setTitle("我的窗口");
        frm.setBackground(Color.red);
        frm.setLocation(200,200);
        JButton b =new JButton("确定");
        frm.add(b);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setVisible(true);
    }
}
