package cn.llynsyw.java.basic.day09.demo02;

public class Demo02GenericClass {
    public static void main(String[] args) {
        GenericClass <String> gc=new GenericClass<>();
        gc.setName("LLY");
        System.out.println(gc.getName());
    }
}
