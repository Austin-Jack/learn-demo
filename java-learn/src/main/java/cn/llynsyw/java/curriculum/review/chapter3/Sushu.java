package cn.llynsyw.java.curriculum.review.chapter3;

public class Sushu {
    public static void main(String args[]) {
        final int NUM = 100;
        int i = 2;

        for (; i < NUM; i++) {
            int j = 2;
            for (; j < i; j++) {
                if (i % j == 0) {
                    break;
                }
            }
            if (j == i)
                System.out.println(i + "��������");
        }
    }

}
