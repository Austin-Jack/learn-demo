package cn.llynsyw.java.basic.Strength.demo02.reflect;

import java.lang.reflect.Method;

/**
 * @ClassName ReflectDemo04
 * @Description
 * @package demo02.reflect
 * @Author luolinyuan
 * @Date 2021/7/26
 **/
public class ReflectDemo04 {
    public static void main(String[] args) throws Exception {
        //0.获取Person的Class对象
        Class personClass=Person.class;

        //获取指定方法名称的方法
        Method eat_method=personClass.getMethod("eat");
        //执行方法Object invoke(Object obj, Object... args)
        Person p=new Person();
        //执行方法
        eat_method.invoke(p);

        //获取指定方法名称的方法,给定参数区分重载
        Method eat_method2=personClass.getMethod("eat",String.class);
        eat_method2.invoke(p,"饭");

        System.out.println("----------------");

        //获取所有public修饰的方法,包括父类Object类的方法
        Method[] methods=personClass.getDeclaredMethods();
        for (Method method:methods){
            //System.out.println(method);
            System.out.println(method.getName());//打印方法的名称
        }

        //获取类名
        String name = personClass.getName();
        System.out.println(name);


    }
}
