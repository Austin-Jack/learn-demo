package cn.llynsyw.java.task.week01.day06.someKeywords.staticDemo;

public class StaticDemo {


    public  static void doSomething(){
        System.out.println("static method");
    }
    public void doSomething2(){
        doSomething();
    }
    public static void main(String[] args) {
        doSomething();
    }
}

class StaticFiled{
    private static int a=0;
    private int b=0;

    public static void printA(int a){
        System.out.println(a);
        //System.out.println(b);  b是非静态成员变量无法在这访问
    }

    public void printAB(){
        System.out.println(a);//非静态成员方法能访问静态成员变量
        System.out.println(b);
    }

    public static void main(String[] args) {
        StaticFiled sf1=new StaticFiled();
        StaticFiled sf2=new StaticFiled();
        System.out.println(++sf1.b);
        System.out.println(++sf1.a); //会影响其他对象中的该变量
        System.out.println(++sf2.b);
        System.out.println(++sf2.a);
    }
}

class StaticBlock{
    static {
        System.out.println("static block..");
    }

    public static void main(String[] args) {

    }
}
