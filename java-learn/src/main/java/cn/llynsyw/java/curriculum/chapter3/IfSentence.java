package cn.llynsyw.java.curriculum.chapter3;

import java.util.Scanner;//导入Scanner类包

public class IfSentence {

    public static void main(String[] args) {
        //声明三个整型变量用以接收带输入数值
        int a=0,b=0,c=0,max=0;
        Scanner reader=new Scanner(System.in);//声明Scanner实例对象reader

        System.out.println("从键盘输入第一个整数：");
        a=reader.nextInt();

        System.out.println("从键盘输入第二个整数");
        b=reader.nextInt();

        System.out.println("从键盘输入第三个整数");
        c=reader.nextInt();
        //对比得出最大值
        if(a>b)
            max=a;
        else
            max=b;
        if(c>max)
            max=c;

        System.out.println("最大的数是："+max);
    }
}
