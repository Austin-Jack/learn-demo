package cn.llynsyw.java.curriculum.chapter2;

public class Conver {

public static void main(String[] args) {
    //声明并赋值各基本数据类型变量
	byte a=0;     short b=0;
	int c=0;      long d=0;
    float e=0F;   double f=0D;
    String s="10";

    //字符串与数值型数据的相互转换
    a=Byte.parseByte(s);
    b=Short.parseShort(s);
    c=Integer.parseInt(s);
    d=Long.parseLong(s);
    e=Float.parseFloat(s);
    f=Double.parseDouble(s);

    //输出各个变量查看转化结果
    System.out.println(a);
    System.out.println(b);
    System.out.println(c);
    System.out.println(d);
    System.out.println(e);
    System.out.println(f);

    //验证加号连接字符串与数值型数据的功能
    int MyInt=1234;
    String MyString=""+MyInt;

    //输出显示验证结果
    System.out.println(MyString);
   
 }
}
