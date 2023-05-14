package cn.llynsyw.java.basic.day02.demo05;

import java.util.Scanner;

public class Demo02ScannerTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a, b;
        a = sc.nextInt();
        b = sc.nextInt();
        System.out.println("结果是" + add(a,b));

    }

    public static int add(int a, int b) {
        return  a+b;
    }
}
