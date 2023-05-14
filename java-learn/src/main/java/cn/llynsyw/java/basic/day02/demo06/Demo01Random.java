package cn.llynsyw.java.basic.day02.demo06;

import java.util.Random;

public class Demo01Random {
    public static void main(String[] args) {
        Random r=new Random();
        int num =r.nextInt();//没有参数的时候是个int范围内的伪随机数
        System.out.println(num);
        num=r.nextInt(3);//在有int参数时代表范围此处为 [0，3）的数字
        System.out.println(num);
    }
}
