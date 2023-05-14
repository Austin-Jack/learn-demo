package cn.llynsyw.java.basic.day05.demo02;


public class Dog extends Animal {
    @Override
    void eat() {
        System.out.println("狗吃屎");
    }

    public void characterOfDog(){
        System.out.println("憨憨");
    }
}
