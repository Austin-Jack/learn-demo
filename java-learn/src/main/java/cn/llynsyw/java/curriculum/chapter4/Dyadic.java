package cn.llynsyw.java.curriculum.chapter4;

import java.util.Arrays;//导入Arrays类包

public class Dyadic {

    public static void main(String[] args) {
        int i,j;
        int[][] a;//声明二维数组a
        a=new int[2][3];//申请二维数组a空间为两行三列
        for (i=0;i<2;i++) {
            for (j = 0; j < 3; j++) {
                a[i][j] = (int) (Math.random() * 100);//随机产生并赋值到数组a中
                System.out.printf("a["+i+"]"+"["+j+"]="+a[i][j]+"  ");//遍历输出a的各个数值
            }
            System.out.println();
        }


        Arrays.sort(a[0]);//将二维数组a的第一行从小大排序
        Arrays.sort(a[1]);//将二维数组a的第一行从小大排序

        for (i=0;i<2;i++)
        {
            if(i==0)//遍历输出第一行元素
                System.out.println("排序后,第一行元素从小到大是:");
            if(i==1)//遍历输出第二行元素
                System.out.println("排序后,第二行元素从小到大是:");
            for(j=0;j<3;j++)
                System.out.print("a["+i+"]["+j+"]="+a[i][j]+"  ");

            System.out.println();
        }
    }
}
