package cn.llynsyw.java.curriculum.chapter6;

public class MyPlus {
    //�÷������Եó�������a+b��ֵ
    public int plus(int a,int b)
    {
        int s;
        s=a+b;
        return s;
    }
    //�÷������Եó�������a+b+c��ֵ
    public int plus(int a,int b, int c)
    {
        int s;
        //����plus(a,b)�����ó�a+b��ֵ
        s=plus(plus(a,b),c);
        return s;
    }
    //�÷������Եó�������a+b+c+d��ֵ
    public int plus(int a,int b,int c,int d)
    {
        int s;
        //����/plus(a,b,c)�����ó�a+b+c��ֵ
        s=plus(plus(a,b,c),d);
        return s;
    }

    //������
    public static void main(String[] args) {
        MyPlus p=new MyPlus();
        //����plus()������1+2��ֵ����ʾ
        System.out.println("1+2="+p.plus(1,2));
        //����plus()������1+2+3��ֵ����ʾ
        System.out.println("1+2+3="+p.plus(1,2,3));
        //����plus()������1+2+3+4��ֵ����ʾ
        System.out.println("1+2+3+4="+p.plus(1,2,3,4));
    }
}
