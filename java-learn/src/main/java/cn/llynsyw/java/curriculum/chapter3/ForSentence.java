package cn.llynsyw.java.curriculum.chapter3;

public class ForSentence {

    public static void main(String[] args) {
        int s=0;

        for(int i=1;i<100;i++){//从1+3+..到99
            s+=i;
            i++;
        }
        //显示输出结果
        System.out.print("1+3+5+...+99="+s);
    }
}
