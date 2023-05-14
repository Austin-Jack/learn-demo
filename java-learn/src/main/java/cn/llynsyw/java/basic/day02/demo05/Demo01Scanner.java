package cn.llynsyw.java.basic.day02.demo05;

import java.util.Scanner;
/*
    只有在java.lang下才不需要导包
    1.导包
    import.包路径.类名；
    2.创建
    类名称 对象名=new 类名称();
    3.使用
    对象名.成员方法名。
 */
public class Demo01Scanner {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);//从键盘输入
        int num=sc.nextInt();
        System.out.println(num);
        String str=sc.next();
        System.out.println(str);

    }
}
