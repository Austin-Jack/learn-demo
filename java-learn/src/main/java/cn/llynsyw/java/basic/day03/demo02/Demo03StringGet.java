package cn.llynsyw.java.basic.day03.demo02;

/*
public int length():获取字符串当中含有的字符个数
public String concat(String str)：当前字符串和参数字符串拼接成一个新的字符串并返回
public char charAt(int index):获取指定索引位置的单个字符(索引从0开始)
public int indexOf (String str):查找参数字串在本字符串当中首次出现的索引位置，如果没有则返回-1
 */
public class Demo03StringGet {
    public static void main(String[] args) {
        //获取字符串的长度
        System.out.println("ADADJAKDJAKDJAKJDKAXNKAKhhah和".length());

        String str1="hello";
        String str2="World";
        String str3=str1.concat(str2);
        System.out.println(str3);
        System.out.println("=================");
        //获取指定索引的单个字符
        System.out.println(str3.charAt(0));
        System.out.println(str3.indexOf("Wo"));


    }
}
