package cn.llynsyw.java.task.week01.day04;

public class Overload {
    public static void main(String[] args) {
        int a=0;
        double b=0;
        System.out.println(add(a, b));
        double m=1.1,n=1.2;
        System.out.println(add(m,n));
    }

    public static int add(int a,int b){
        System.out.println("调用方法:int add(int a,int b)");
        return a+b;
    }

    public static double add(double a,double b){
        System.out.println("调用方法：double add(double a,double b)");
        return  a+b;
    }
}
