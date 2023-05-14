package cn.llynsyw.java.basic.day08.demo02;

public class ObjectDemo {
    public String toString(){
        return  getClass().getName();
    }

    public static void main(String[] args) {
        System.out.println(new ObjectDemo());
    }
}
