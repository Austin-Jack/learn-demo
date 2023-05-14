package cn.llynsyw.java.basic.day04.demo02;

/*
在父子类的继承关系当中，创建子类对象，访问成员方法规则
        创建的对象是谁，就优先用谁，如果没有则向上找
        【注意】 只能向上找
        重写（Override)
        概念：在继承关系当中，方法的名称一样，参数列表也一样
        重写(Override)：方法的名称一样，参数列表【也一样】覆盖，重写
        重载(Overload)：方法的名车一样   参数列表【不一样】

       1. @Override : 写在方法前面，用来检测是不是有效的正确覆盖重写
       2.子类方法的返回值必须小于等于父类方法的返回值
       object类为所有类的公共最高父类
       3.子类方法的权限必须【大于等于】父类方法的权限修饰符。
       public>protected>(default)>private
       default为留空

*/
public class Demo02ExtendsMethod {
    public static void main(String[] args) {
        Father father=new Father();
        Son son=new Son();
        father.method();
        son.method();
    }
}
