package cn.llynsyw.java.basic.day06.demo02;

/*
当final 关键字用来修饰一个类的时候，
格式：
public final class 类名称{
    //...
}
含义：当前这个类不能有任何的子类
注意：一个类如果是final类，那么其中所有的成员方法都无法覆盖重写
所以不允许有抽象方法，即final类不能是一个抽象类，没有意义
 */
public   class FinalClass {
    public void  aVoid(){
        System.out.println("这是一个final类");

    }

}
