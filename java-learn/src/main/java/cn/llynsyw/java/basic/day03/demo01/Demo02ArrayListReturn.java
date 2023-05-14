package cn.llynsyw.java.basic.day03.demo01;

import java.util.ArrayList;
import java.util.Random;

/*
用一个大集合存入20个随机数字,然后筛选其中的偶数元素，放到小集合中
 */
public class Demo02ArrayListReturn {
    public static void main(String[] args) {
        ArrayList<Integer> lis = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < 20; i++) {
            lis.add(r.nextInt(55));
        }
        System.out.println(arrayListReturn(lis));
    }


    public static ArrayList<Integer> arrayListReturn(ArrayList<Integer> s) {
        ArrayList<Integer> lis2 = new ArrayList<>();
        for (int i = 0; i < s.size() - 1; i++) {
            int num;
            if (s.get(i) % 2 == 0) {
                num = s.get(i);
                lis2.add(s.get(i));
            }
        }
        return lis2;
    }

}
