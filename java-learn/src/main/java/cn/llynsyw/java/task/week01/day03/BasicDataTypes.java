package cn.llynsyw.java.task.week01.day03;

public class BasicDataTypes {
    public static void main(String[] args) {
        Integer a=123; //自动装箱
        doSomething(a);
        int c=a+1213;    //自动拆箱
        System.out.println(c);
    }

    public static void doSomething(Object obj){
        System.out.println(obj);
    }

}
