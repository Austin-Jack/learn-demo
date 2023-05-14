package cn.llynsyw.java.basic.day02.demo02;

public class Demo04Arraymax {
    public static void main(String[] args) {

        int[] arrayA=new int[]{1,2,1,5,6,5,2,7,8,9,21,23,24,22,23,99};
        int max=arrayA[0];
        for(int i=1;i<arrayA.length;i++){
            if(arrayA[i]>max){
                max=arrayA[i];
            }
        }
        System.out.println(max);
    }
}
