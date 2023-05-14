package cn.llynsyw.java.basic.day02.demo06;

import java.util.Random;
import java.util.Scanner;

public class Demo02RandomGame {
    public static void main(String[] args) {
        Random r = new Random();
        Scanner sc = new Scanner(System.in);

        int num = r.nextInt(101);
        int index;
        System.out.println("请猜一个数字，0~100之间");
        do {
            index = sc.nextInt();
            if (index == num) {
                System.out.println("恭喜你答对了");
            } else if (index < num) {
                System.out.println("猜小了");
            } else if (index > num) {
                System.out.println("猜大了");
            }


        } while (index != num);
    }
}
