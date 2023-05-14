package cn.llynsyw.java.curriculum.chapter4;

public class LinearA {

    public static void main(String[] args) {
        int i;
        int[] a;//声明一维数组a
        a = new int[10];//申请一维数组a的空间

        for (i = 0; i <= a.length - 1; i++)//遍历输出数组a的值
            System.out.print("a[" + i + "]" + "=" + a[i] + " ");
        System.out.println("");

        for (i = a.length - 1; i >= 0; i--) {
            a[i] = i;//依次将数组赋值为i
            System.out.print("a[" + i + "]=" + a[i] + " ");//显示输出a[i]的值
        }
    }
}
