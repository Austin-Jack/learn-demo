package cn.llynsyw.java.basic.day07.demo02;

import java.util.Arrays;

public class MyArrays {
    public static void main(String[] args) {
        int[] a=new int[]{1,2,9};
        int []b=Arrays.copyOf(a,5);
        int index= Arrays.binarySearch(a,8);
        System.out.println(index);//-3 "-"为插入符

    }

}
