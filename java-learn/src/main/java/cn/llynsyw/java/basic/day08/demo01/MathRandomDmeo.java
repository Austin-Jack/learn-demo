package cn.llynsyw.java.basic.day08.demo01;

/*
Math.Random()可以返回一个[0,1)的随机double类型值
 */
public class MathRandomDmeo {
    public static void main(String[] args) {
        //输出[0,9)的随机整数值
        System.out.println((int) (Math.random() * 9));
        //输出[8,90)的随机整数
        System.out.println(8 + (int) (Math.random() * (90 - 8)));
        //输出a~z的随机字母
        //(char)(char1+Math.random()*(char2-char1+1))语句可以实现求出char1~char2之间的随机字符
        System.out.println((char)('a'+Math.random()*('z'-'a'+1)));
    }
}
