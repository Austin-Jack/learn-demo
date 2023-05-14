package cn.llynsyw.java.curriculum.chapter4;

import java.util.Scanner;

public class LinearB {

    public static void main(String[] args) {
        int i,max,min;
        int[] a=new int[5];//声明并申请一维数组的空间,大小为5
        Scanner reader=new Scanner(System.in);//声明Scanner实例对象reader

        for (int j=0;j<5;j++) {//依次输入并赋值给对应a[i]
            System.out.println("从键盘输入一个整数到a["+j+"]:");
            a[j]=reader.nextInt();
        }

        max=a[0];
        min=a[0];
        for(i=1;i<5;i++)//找出数组a中的最大值
        {
            if(a[i]>max)
                max=a[i];
            if(a[i]<min)
                min=a[i];
        }
        //分别显示输出最大值和最小值
        System.out.println("最大的数是"+max);
        System.out.println("最小的数是"+min);
    }
}
