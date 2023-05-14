package cn.llynsyw.java.task.week01.day06.someKeywords.interfaceDemo;

public interface InterfaceDemo {
    public static  final int a=1;

    public static void test1() {
        System.out.println(a);
    }

    public void test2();
}

class Test implements InterfaceDemo{
    @Override
    public void test2() {
        System.out.println("implements test2");
    }


    public static void main(String[] args) {

    }
}
