package cn.llynsyw.java.basic.day03.demo04;

import java.util.Arrays;

/*
使用Arrays 相关的API，将一个随机字符串中的所有字符升序排列，并倒叙打印。
 */
public class Demo02ArraysPractise {

    public static void main(String[] args) {
        String str="aksjakdjk212313kjaksjkajskaj";
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        for (int i = chars.length-1; i >=0; i--) {
            System.out.print(chars[i]);
        }
    }

}
