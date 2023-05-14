package cn.llynsyw.java.basic.day02.demo02;

//数组元素反转
public class Demo05ArrayReverse {
    public static void main(String[] args) {
        int[] arrayA = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        int min = 0;
        int max = arrayA.length - 1;
        for (int i = 0; i < arrayA.length; i++) {
            System.out.println(arrayA[i]);
        }
        for (; min < max; min++, max--) {
            int temp = arrayA[min];
            arrayA[min] = arrayA[max];
            arrayA[max] = temp;
        }
        System.out.println("============");
        for (int i = 0; i < arrayA.length; i++) {
            System.out.println(arrayA[i]);

        }
    }

}
