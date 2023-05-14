package cn.llynsyw.java.basic.day02.demo02;

public class Demo02DoubleArray {
    public static void main(String[] args) {
        //两个引用指向同一个数组
        int[] arrayA=new int[]{1,2,3};
        System.out.println(arrayA[0]);
        int [] arrayB=arrayA;//指向同一内存地址
        arrayB[0]=10;
        System.out.println(arrayB[0]);
        System.out.println("=============");
        System.out.println(arrayA[0]);

    }
}
