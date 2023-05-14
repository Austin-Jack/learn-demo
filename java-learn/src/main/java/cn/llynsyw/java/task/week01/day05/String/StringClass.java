package cn.llynsyw.java.task.week01.day05.String;

public class StringClass {
    public static void main(String[] args) {
        String str1="hello";
        String str2="hello";

        String str3=str1;
        String str4=new String(str1);
        System.out.println("str1==str2? "+(str1==str2));
        System.out.println("str1==str3? "+(str1==str3));
        System.out.println("str1==str4? "+(str1==str4));
    }
}
