package cn.llynsyw.java.curriculum.review.chapter3;

public class A {
    public static void main(String[] args) {

    }
    void test(){
        System.out.print("A");
    }
}

class B extends A{
    void test()
    {
        super.test();
        System.out.print("B");
    }
}
