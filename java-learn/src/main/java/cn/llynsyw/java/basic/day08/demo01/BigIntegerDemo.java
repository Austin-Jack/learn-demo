package cn.llynsyw.java.basic.day08.demo01;

import java.math.BigInteger;

//该类可以处理更大的数字，最直接的构造方法是将字符串中数字
public class BigIntegerDemo {
    public static void main(String[] args) {
        BigInteger bigInstance=new BigInteger("454545425454544512354545455151544878");
        bigInstance=bigInstance.pow(10000);
        System.out.println(bigInstance);
    }
}
