package cn.llynsyw.java.basic.day06.demo02;

/*
当final关键字用来修饰一个方法的时候，这个方法就是最终方法，也就不能被覆盖重写。
格式
修饰符 final 返回值类型 方法名(){
    //方法体
}
注意：
对于类、方法来说，abstract关键字和final关键字不能同时使用，因为矛盾



对于成员变量来说，如果使用final关键字修饰，那么这个变量也照样是不可变的
1.由于成员变量具有默认值，所以用了final之后必须手动赋值，不会再给默认值
2.对于final的成员变量，要么使用直接赋值，要么通过构造方法赋值，二者选其一
3.必须保证类当中所有重载的构造方法，都最终对final的成员变量进行赋值
 */
public class Father {
    int num2;
    //final int num=10;//第一种可以直接赋值
    final int num;//第二种，通过构造方法赋值，但是所有构造方法的重载都必须给他赋值

    public Father() {
        num=10;
    }

    public Father(int num3) {
        this.num2 = num3;
        this.num = 20;
    }

    public final void finalMethod() {
        System.out.println("这是一个最终方法");
    }

    public void commonMethod() {
        System.out.println("这是一个父类普通方法");
    }
}
