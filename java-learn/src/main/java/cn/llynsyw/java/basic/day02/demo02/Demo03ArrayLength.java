package cn.llynsyw.java.basic.day02.demo02;

/*
程序运行过程中数组长度不能更改。
*/
public class Demo03ArrayLength {
    public static void main(String[] args) {
        int[] arrayA = new int[3];//new出来的才是真的内容 arrayA只是名字
        System.out.println(arrayA.length);
        arrayA = new int[5];
        System.out.println(arrayA.length);
    }
}
