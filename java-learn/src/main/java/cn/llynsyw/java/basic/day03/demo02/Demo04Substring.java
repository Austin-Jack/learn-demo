package cn.llynsyw.java.basic.day03.demo02;

/*
字符串的截取方法

Public String substring (int index):从当前索引开始截取到末尾，返回一个新字符串
public String substring (int begin,int end):从begin索引位置开始截取到end 【begin,end)

 */
public class Demo04Substring {
    public static void main(String[] args) {
         String str1="helloWorld";
         String str2=str1.substring(3);
        System.out.println(str2);
    }
}
