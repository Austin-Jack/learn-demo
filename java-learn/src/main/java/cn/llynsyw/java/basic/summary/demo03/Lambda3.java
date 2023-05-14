package cn.llynsyw.java.basic.summary.demo03;

public class Lambda3 {
    public static void main(String[] args) {
        PintSomething p1=(a,str)->{
            System.out.println(a+str);
        };
        p1.printSomething(1,".第一条");
    }


}

interface PintSomething{
    void printSomething(int a,String str);
}
