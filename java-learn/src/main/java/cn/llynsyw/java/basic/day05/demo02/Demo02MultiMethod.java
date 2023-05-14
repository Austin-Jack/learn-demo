package cn.llynsyw.java.basic.day05.demo02;


/*
在多态的代码当中，成员方法的访问规则是：
    看new的是谁，就优先使用谁，没有则向上找。


口诀：
成员变量：编译看左边，运行还看左边。
成员方法：编译看左边，运行看右边。
 */
public class Demo02MultiMethod {
    public static void main(String[] args) {
        Fu obj=new Zi();
        System.out.println(obj.num);//直接输出父类中的变量 10
        obj.showNum();//先看子类中是否有该方法  执行子类的方法 输出  20
    }
}
