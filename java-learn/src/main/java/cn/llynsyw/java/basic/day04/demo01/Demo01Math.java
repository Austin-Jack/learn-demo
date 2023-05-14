package cn.llynsyw.java.basic.day04.demo01;

/*
java.lang.Math类是数学工具类，里面装有数学操作的静态方法

public static double abs(double num) 获取绝对值，有多种重载
public static double ceil (double num) 向上取整
public static double floor(double num) 向下取整
public static long round (double num)  四舍五入

Math.PI代表圆周率近似值
 */
public class Demo01Math {
    public static void main(String[] args) {
        System.out.println(Math.abs(-2.23));//2.23
        System.out.println(Math.ceil(3.2));//4.0
        System.out.println(Math.floor(3.2));//3.0
        System.out.println(Math.round(3.4));//3
        System.out.println(Math.PI);//3.14...

    }
}
