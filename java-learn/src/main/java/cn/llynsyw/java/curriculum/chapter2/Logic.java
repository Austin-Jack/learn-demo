package cn.llynsyw.java.curriculum.chapter2;

public class Logic {

public static void main(String[] args) {
	//声明布尔类型变量a,x,y,z
	boolean a,x,y,z;

	//将各判断结果赋值给各个变量
	a=5>6;    x=!a;
	y=a&&x;   z=x||a;

	//输出显示各布尔变量的真值情况
	System.out.println("a="+a);
	System.out.println("x="+x);
	System.out.println("y="+y);
	System.out.println("z="+z);
}
}
