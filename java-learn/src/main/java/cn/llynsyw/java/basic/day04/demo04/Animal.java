package cn.llynsyw.java.basic.day04.demo04;

/*
抽象方法：就是加上abstract关键字，然后去掉大括号，直接分号结束1
抽象类：抽象方法所在的类，必须是抽象类才行。在class之前协商abstract即可

如何使用抽象类和抽象方法：
1.不能直接创建new抽象类对象
2.必须用一个子类来继承抽象父类
3.非抽象子类必须覆盖重写抽象父类当中所有的抽象的方法

抽象类中不一定有抽象方法 【这样的抽象类有其他用途，设计模式，适配器】
如果有抽象方法那么一定是抽象类
 */
public abstract class Animal {
    //抽象方法，代表某动物吃东西，但具体并不知道
    public abstract void eat();


}
