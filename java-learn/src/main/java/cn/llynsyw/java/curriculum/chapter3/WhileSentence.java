package cn.llynsyw.java.curriculum.chapter3;

import java.util.Scanner;

public class WhileSentence {

    public static void main(String[] args) {
        //声明三个整型变量接收带输入整数
        int a=0,i=1,s=0;
        //声明Scanner实例对象reader
        Scanner reader=new Scanner(System.in);

        while(a<50||a>100){//直到输入数值小于50或者大于100时循环结束
            System.out.println("从键盘输入一个50~100的整数");
            a=reader.nextInt();//获取输入的值
        }
        System.out.println("你输入的数是"+a);
        while(i<=a){//从1+到a
            s+=i;
            i++;
        }
        //显示输出结果
        System.out.println("1+2+3+4+...+a+"+"="+s);
    }
}
