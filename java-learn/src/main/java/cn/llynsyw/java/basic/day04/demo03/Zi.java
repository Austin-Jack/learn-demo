package cn.llynsyw.java.basic.day04.demo03;

public class Zi extends Fu {

    public Zi() {

        //super(); 默认赠送无参父类构造
        super(10);//必须是子类构造方法的第一行代码 有父才有子
        System.out.println("子类构造方法执行");
    }
}
