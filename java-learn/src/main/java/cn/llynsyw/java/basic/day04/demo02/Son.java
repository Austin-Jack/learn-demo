package cn.llynsyw.java.basic.day04.demo02;

public class Son extends Father{

    int num=20;
    @Override
    public String  method(){
        System.out.println("子类的方法执行！");
        int num=30;
        System.out.println(num);
        System.out.println(this.num);
        System.out.println(super.num);
        return  null;
    }
}
