package cn.llynsyw.java.basic.day03.demo04;

import java.util.Arrays;

/*
java.util.Arrays是一个与数组相关的工具类，里面提供了大量静态方法，用来实现数组常见的操作

public static String toString (数组)：将数组以[元素1，元素2，元素3]形式返回为字符串形式
public static void sort (数组):将数组以升序的方式排列

备注：
1.如果是数值，sort默认按照升序排序
2.如果是字符串,sort默认按照字母升序
3.如果自定义的类型，那么这个自定义的类需要有Comparable或者Comparator接口的支持
 */
public class Demo01Arrays {
    public static void main(String[] args) {
        int [] array=new int[]{1,2,3,232,14,2,45325,35};
        String str= Arrays.toString(array);
        String[] str2=new String[]{"bbb","aaa","ddd"};
        System.out.println(str);
        Arrays.sort(array);
        str= Arrays.toString(array);
        System.out.println(str);
        Arrays.sort(str2);
        System.out.println(Arrays.toString(str2));

    }
}
