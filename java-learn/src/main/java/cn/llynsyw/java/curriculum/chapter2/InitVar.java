package cn.llynsyw.java.curriculum.chapter2;

public class InitVar {

 public static void main(String[] args) {
 	//声明并初始化各基本数据类型变量
	byte a=10;      short b=20;
	int c=30;       long d=40L;
	float e=50F;    double f=60D;
	char g='A';     boolean h=true;
	final double pi=3.14;

	//输出各数据值,用+连接数据类型和字符串
	System.out.println("字节型,a="+a);
	System.out.println("短整型,b="+b);
	System.out.println("整数型,c="+c);
	System.out.println("长整型,d="+d);
	System.out.println("单精度型,e="+e);
	System.out.println("双精度型,f="+f);
	System.out.println("字符型,g="+g);
	System.out.println("布尔型,h="+h);
	System.out.println("圆周率,pi="+pi);
}
}
