package cn.llynsyw.jvm.chapter01;

public class StaticClass {
    static int count1 = 0;
    private static StaticClass staticClass = new StaticClass();
    static int count2 = 1;
    static int count3 = 3;
    static  {
        count3++;
    }

    public StaticClass() {
        count1++;
        count2++;
        ++count3;
    }

    static StaticClass getInstance(){return staticClass;};
}

class Test {
    public static void main(String[] args) {
        StaticClass staticClass = StaticClass.getInstance();
        System.out.println(staticClass.count1);
        System.out.println(staticClass.count2);
        System.out.println(staticClass.count3);
        
    }
}