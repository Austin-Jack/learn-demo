package cn.llynsyw.java.curriculum.chapter2;

import java.util.Scanner;//导入Scanner类

public class InputNum {

public static void main(String[] args) {
	//声明四种常用数据类型存储键入内容
	int a=0;       float b=0f;
	double c=0D;   String s="";

	//声明一个Scanner实例对象
	Scanner reader=new Scanner(System.in);
	System.out.println("从键盘输入一串字符:");
	//接收用户所输入的所有内容并显示
	s=reader.nextLine();
	System.out.println("你输入的字符串是:"+s);

	System.out.println("从键盘输入一个整数:");
	//接收用户所输入的整数型并显示
	a=reader.nextInt();
	System.out.println("你输入的整数是:"+a);

	System.out.println("从键盘输入一个单精度浮点数:");
	//接收用户所输入的单精度浮点数并显示
	b=reader.nextFloat();
	System.out.println("你输入的单精度浮点数是："+b);

	System.out.println("从键盘输入一个双精度浮点数:");
	//接收用户所输入的双精度浮点数并显示
	c=reader.nextDouble();
	System.out.println("你输入的双精度浮点数是:"+c);
 }
}
