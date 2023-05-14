package cn.llynsyw.java.basic.day02.demo07;

import java.util.ArrayList;
import java.util.Random;

/*
生成6个1~33之间的随机整数,添加到集合，并遍历集合
 */
public class Demo04ArrayListRandom {
    public static void main(String[] args) {
        Random r = new Random();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            int num = r.nextInt(33) + 1;
            list.add(num);
        }
        System.out.println("生成的随机六个数为" + list);
        for (int i = 0; i < 6; i++) {
            System.out.println(list.get(i));

        }
    }
}

