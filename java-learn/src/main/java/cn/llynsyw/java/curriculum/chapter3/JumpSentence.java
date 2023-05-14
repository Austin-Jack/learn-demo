package cn.llynsyw.java.curriculum.chapter3;

public class JumpSentence {

    public static void main(String[] args) {
        for(int i=1;i<10;i++)
        {
            if(i==6)
                break;
            System.out.printf(" "+i);
        }
        System.out.println("\n��ʾ���");

        for(int i=1;i<10;i++)
        {
            if(i%2==0)
                continue;
            System.out.printf(" "+i);
        }
        System.out.println("\n��ʾ���");
    }
}
