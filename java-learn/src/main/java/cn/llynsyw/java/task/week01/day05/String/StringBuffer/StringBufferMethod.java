package cn.llynsyw.java.task.week01.day05.String.StringBuffer;

public class StringBufferMethod {
    public static void main(String[] args) {
        String str1 = "str1";
        StringBuffer sbf1 = new StringBuffer(str1);//传入String实例
        StringBuffer sbf2 = new StringBuffer(2);//指定容量
        StringBuffer sbf3 = new StringBuffer();//空参构造

        /*System.out.println(sbf1.length()+" "+sbf2.length()+" "+sbf3.length());
        System.out.println(sbf1.capacity()+" "+sbf2.capacity()+" "+sbf3.length());*/

        System.out.println("Before append the capacity:"+sbf2.capacity());
        sbf2.append("hello");
        sbf2.append(2 == 3);
        System.out.println("After append the capacity:"+sbf2.capacity());
        System.out.println(sbf2);
        StringBuilder stringBuilder=new StringBuilder();
    }
}
