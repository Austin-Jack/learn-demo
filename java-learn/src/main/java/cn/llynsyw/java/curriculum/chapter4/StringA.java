package cn.llynsyw.java.curriculum.chapter4;

public class StringA {

    public static void main(String[] args) {
        String str1="Hello";//str1 str2不用new申请空间,同存在常量池中
        String str2="Hello";
        String str3=new String("Hello");//str3 str4分别用new申请空间,地址不同
        String str4=new String("Hello");

        System.out.println("运算符==");
        if(str1==str2)//判断str1,str2地址是否相同
            System.out.println("str1与str2相等");
        else
            System.out.println("str1与str2不相等");

        if(str3==str4)//判断str3,str4地址是否相同
            System.out.println("str3与str4相等");
        else
            System.out.println("str3与str4不相等");

        if(str2==str3)//判断str2,str3地址是否相同
            System.out.println("str2与str3相等");
        else
            System.out.println("str2与str3不相等");

        System.out.println("equals()方法");//判断字符串是否相同(及它的值),这里都为hello,都相同
        if(str1.equals(str2))
            System.out.println("str1与str2相等");
        else
            System.out.println("str1与str2不相等");

        if(str3.equals(str4))
            System.out.println("str3与str4相等");
        else
            System.out.println("str3与str4不相等");

        if(str2.equals(str3))
            System.out.println("str2与str3相等");
        else
            System.out.println("str2与str3不相等");
    }
}
