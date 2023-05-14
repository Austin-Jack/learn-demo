package cn.llynsyw.java.basic.day06.demo02;


/*
final 关键字代表最终、不可改变的
常见四种用法：
1.可以用来修饰一个类
当final 关键字用来修饰一个类的时候，
格式：
public final class 类名称{
    //...
}
含义：当前这个类不能有任何的子类
注意：一个类如果是final类，那么其中所有的成员方法都无法覆盖重写
所以不允许有抽象方法，即final类不能是一个抽象类，没有意义

2.可以用来修饰一个方法
当final关键字用来修饰一个方法的时候，这个方法就是最终方法，也就不能被覆盖重写。
格式
修饰符 final 返回值类型 方法名(){
    //方法体
}
注意：
对于类、方法来说，abstract关键字和final关键字不能同时使用，因为矛盾

3.还可以用来修饰一个局部变量
使用final修饰一个局部变量时，只能被赋值一次。
格式：
final 类型 变量名=初始值
注：
对于基本类型来说，不可变说的是变量当中的数据不可变
对于引用类型来说，不可变是说的变量当中的地址值不可改变


4.还可以用来修饰一个成员变量
对于成员变量来说，如果使用final关键字修饰，那么这个变量也照样是不可变的
1.由于成员变量具有默认值，所以用了final之后必须手动赋值，不会再给默认值
2.对于final的成员变量，要么使用直接赋值，要么通过构造方法赋值，二者选其一
3.必须保证类当中所有重载的构造方法，都最终对final的成员变量进行赋值

 */
public class Demo01Final {
    public static void main(String[] args) {
        Father f = new Son(20);//不同的构造方法final型的num值会不同
        //Father f2=new Son();//报错 因为调用无参构造里面尝试再给num赋值 导致错误 num的地址值不会改变
        f.commonMethod();

        System.out.println(f.num);//num=10

    }
}