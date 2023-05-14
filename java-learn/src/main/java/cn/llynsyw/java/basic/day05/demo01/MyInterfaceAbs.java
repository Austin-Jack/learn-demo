package cn.llynsyw.java.basic.day05.demo01;/*
在任何版本的Java中，接口都能定义抽象方法。
格式
public abstract 返回值类型 方法名称（参数列表）；

注意：
1，接口当中的抽象方法，修饰符必须是两个固定的关键字：public abstract
2.这两个关键字修饰符，可以选择性地省略（熟悉后）
3.方法的三要素，可以随意定义



 */

public interface MyInterfaceAbs {
    //接口中的常量
    public static final int NUM=10;

    public abstract void method1();
    public abstract void method2();
    public abstract void method3();

    //已投入使用不能这样添加新的
   // public abstract void method4();

    //新添加的方法，改成默认方法
    //同时可以被重写
    public default  void method4(){
        System.out.println("这是新添加的默认方法");
    }

    public  static  void  methodStatic(){
        System.out.println("这是一个静态方法");
    }



}
