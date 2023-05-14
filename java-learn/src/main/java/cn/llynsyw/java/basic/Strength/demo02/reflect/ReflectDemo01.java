package cn.llynsyw.java.basic.Strength.demo02.reflect;

/**
 * @ClassName ReflectDemo01
 * @Description
 * @package demo02.reflect
 * @Author luolinyuan
 * @Date 2021/7/25
 **/
public class ReflectDemo01 {
    public static void main(String[] args) throws ClassNotFoundException {
        //1.Class.forName("全类名")
        Class cls1 = Class.forName("demo02.reflect.Person");
        System.out.println(cls1);

        //2.类名.class
        Class cls2=Person.class;
        System.out.println(cls2);

        //3.对象.class()
        Person person=new Person();
        Class cls3=person.getClass();
        System.out.println(cls3);

        //使用==比较三个对象
        System.out.println("cls1==cls2? "+(cls1==cls2));
        System.out.println("cls1==cls3? "+(cls1==cls3));
        System.out.println("cls2==cls3? "+(cls2==cls3));
    }
}
