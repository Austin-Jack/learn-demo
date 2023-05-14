package cn.llynsyw.java.basic.day06.demo02;


/*
可见 无法覆盖重写父类的final方法
 */
public class Son extends Father {
    public Son(int num2) {
        super(num2);
    }

    @Override
    public void commonMethod() {
        System.out.println("父类方法已被覆盖重写");
    }
}
