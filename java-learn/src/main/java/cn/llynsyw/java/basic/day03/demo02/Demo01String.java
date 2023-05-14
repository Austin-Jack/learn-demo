package cn.llynsyw.java.basic.day03.demo02;

/*
双引号""中的内容即是String类的一个实例，String类在java.lang包下
特点
1.因其为常量，字符串的内容永不可变。
2.正是因为字符串不可改变,所以字符串可以共享使用的.
3.字符串效果上相当于char[]字符数组,但是底层原理是byte[]字节数组。

创建字符串3+1种方式
三种构造方法
public String(),创建一个空白字符串不含有任何内容
public String(char[] array):根据字符数组的内容,来创建对应的字符串.
public String(byte[] array):根据字节数组的内容，来创建对应的字符串
一种直接创建
String str="";
直接创建也是对象
 */
public class Demo01String {
    public static void main(String[] args) {
        //使用空参构造
        String str1=new String();//小括号留空,说明字符串什么内容都没有
        System.out.println("第一个字符串："+str1);//并不是打印null

        //根据字符数组创建字符串
        char[] charArray={'a','b','c','d'};
        String str2=new String(charArray);
        System.out.println("第二个字符串:"+str2);

        //根据字节数组创建字符串
        byte[] byteArray={97,98,99};
        String str3=new String(byteArray);
        System.out.println("第三个字串:"+str3);

    }

}
