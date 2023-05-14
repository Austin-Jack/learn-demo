package cn.llynsyw.java.basic.day03.demo03;


/*
带有static 修饰符的成员变量 或者是成员方法 是属于类的 不同的对象维护同一份数据
静态变量：类名称.静态变量
静态方法：类名称.静态方法

调用本类的静态成员可以不需要类名

【注意】
1.静态不能直接访问非静态
原因：因为在内存当中是先有静态内容后有非静态内容
2.静态方法当中不能用this
原因：this代表当前对象，但是调用静态成员可以没有对象。

静态代码块的格式
static {
    //静态代码块的内容
    }
    特点：当第一次用到本类的时候，静态代码块执行且只执行依次
    静态内总是优先于非静态，所有静态代码块比构造方法先执行

    静态代码块的典型用途
    用来一次性地对静态成员变量进行赋值
 */
public class Demo01Static {
    public static void main(String[] args) {
        Student stu1=new Student();
        Student stu2=new Student();
        stu1.setAge(20);
        stu2.setAge(20);
        stu1.setName("LLY");
        stu2.setName("lala");
        System.out.println("名字:"+stu1.getName()+"年龄:"+stu1.getAge()+"教室:"+Student.getRoom());
        System.out.println("名字:"+stu2.getName()+"年龄:"+stu2.getAge()+"教室:"+Student.getRoom());

    }
}
