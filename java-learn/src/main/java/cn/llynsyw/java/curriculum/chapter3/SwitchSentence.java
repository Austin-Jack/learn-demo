package cn.llynsyw.java.curriculum.chapter3;

import java.util.Scanner;

public class SwitchSentence {

    public static void main(String[] args) {
        //声明并初始化整型变量
        int a=-1;
        Scanner reader=new Scanner(System.in);//声明Scanner实例对象

        do {
            System.out.println("从键盘中输入一个0~6的整数:");
            a=reader.nextInt();
            switch (a)
            {
                case 0:
                    System.out.println("今天是星期日");
                    break;
                case 1:
                    System.out.println("今天是星期一");
                    break;
                case 2:
                    System.out.println("今天是星期二");
                    break;
                case 3:
                    System.out.println("今天是星期三");
                    break;
                case 4:
                    System.out.println("今天是星期四");
                    break;
                case 5:
                    System.out.println("今天是星期五");
                    break;
                case 6:
                    System.out.println("今天是星期六");
                    break;
                default:
                    System.out.println("输入错误!");
                    break;
            }
        }while (a<0||a>6);//当输入的值不符合要求时循环
    }
}
