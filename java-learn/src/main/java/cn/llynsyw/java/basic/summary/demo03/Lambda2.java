package cn.llynsyw.java.basic.summary.demo03;

public class Lambda2 {
    public static void main(String[] args) {
        //1.常规Lambda
        PrintNum p=(int a)->{
            System.out.println("1.打印数字"+a);
        };
        p.printNum(10000);

        //2.去掉形参类型
        p=(a)->{
            System.out.println("2.打印数字"+a);
        };
        p.printNum(10001);

        //3.去掉形参括号
        p=a->{
            System.out.println("3.打印数字"+a);
        };
        p.printNum(10002);

        //4.去掉{} 注意:只能在实现代码只有一行的有情况下使用
        p=a-> System.out.println("4.打印数字"+a);
        p.printNum(10003);
    }
}

interface PrintNum
{
    void printNum(int a);
}