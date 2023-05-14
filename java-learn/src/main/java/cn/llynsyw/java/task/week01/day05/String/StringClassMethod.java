package cn.llynsyw.java.task.week01.day05.String;

public class StringClassMethod {
    public static void main(String[] args) {
        String str1="hello";
        System.out.println(str1+" "+str1.length());
        String str2=str1.concat(" world");
        System.out.println(str2);
        System.out.println(str2+" "+str2.length());
        System.out.println(str2.indexOf("ld"));
    }
}
