package cn.llynsyw.java.basic.day03.demo02;

/*
字符串常量池,程序当中直接写上的双引号字符串,就咋子字符串常量池当中

对于基本类型来说,==是进行数组的比较。
对于引用类型来说，==是进行【地址值】的比较

public boolean equals(Object obj),参数可以是任何对象，只有参数是一个字符串并且内容相同才会返回true
public boolean equalsIgnoreCase(String str)  :忽略大小写进行内容比较
 */
public class Demo02StringPool {
    public static void main(String[] args) {
        String str1="abc";
        String str2="abc";

        char[] charArray=new char[]{'a','b','c'};
        String str3=new String(charArray);//new的不在常量池当中

        System.out.println(str1==str2);
        System.out.println(str2==str3);
        System.out.println(str1==str3);
        System.out.println("============");
        System.out.println(str1.equals(str2));
        System.out.println(str2.equals(str3));
        System.out.println(str1.equals(str3));
        System.out.println("abc".equals(str3));//这样的比较 则将常量写在前面
        System.out.println("==============");
        System.out.println("ABC".equalsIgnoreCase(str1));
    }
}
