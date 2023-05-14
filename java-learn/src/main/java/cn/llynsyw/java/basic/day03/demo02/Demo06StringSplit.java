package cn.llynsyw.java.basic.day03.demo02;

/*
分割字符串的方法：
public String[] split(String regex):按照参数的规则将字符串分割成若干份

注意如果需要以  "."为分割标准则需要 表示为 "\\."
因为参数是一个正则表达式
 */
public class Demo06StringSplit {
    public static void main(String[] args) {
        String str="aaa,bbb,ccc,ddd";
        String[] str2=str.split(",");
        for (int i = 0; i < str2.length; i++) {
            System.out.println(str2[i]);
        }
    }
}
