package cn.llynsyw.java.basic.day04.demo01;

/*
编写一程序 计算在-10.8与5.9之间，绝对值大于6  或者小于2.1 的整数有多少个
 */
public class Demo02MathPractise {
    public static void main(String[] args) {
        int count=0;
        int indexNum;
        int min=(int)Math.ceil(-10.8);
        int max=(int)Math.ceil(5.9);
        for (int i=min;i<max;i++){
            indexNum=Math.abs(i);
            if (indexNum>6){
                count++;
            }
            else if (indexNum<2.1){
                count++;
            }

        }
        System.out.println(count);
    }
}
