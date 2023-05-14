package cn.llynsyw.java.basic.day03.demo02;

/*
String 当中与转换相关的常用方法有：

public char[] toCharArray():将当前字符串拆分成字符数组作为返回值
public byte[] getBytes():获取当前字符串底层的字节数组
public String replace(CharSequence oldString,CharSequence newString);
将所有出现的老字符串替换成新的字符串，返回替换后的新字符串.
备注：CharSequence意思就是可以接受字符串类型

 */
public class Demo05StringConvert {
    public static void main(String[] args) {
        char[] chars = "hello".toCharArray();
        System.out.println(chars[0]);
        System.out.println(chars.length);
        System.out.println("============");

        //获取最低成的字节数组
        byte[] bytes = "zhehisgejxjhsk好玩".getBytes();
        for (int i = 0; i < bytes.length; i++) {
            System.out.print(bytes[i]+" ");
        }
        System.out.println("\n=============");
        String str="你个菜逼，会不会玩";
        System.out.println("替换前："+str);

        System.out.println("替换后："+str.replace("菜逼","**"));
    }
}
