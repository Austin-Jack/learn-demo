package cn.llynsyw.java.basic.day02.demo01;

public class Demo02MethodOveroadPrint {
    public static void main(String[] args) {

        myPrint("hello");
        myPrint(01);
    }

    public static void myPrint(int num) {
        System.out.println(num);
    }

    public static void myPrint(String str) {
        System.out.println(str);
    }
}
