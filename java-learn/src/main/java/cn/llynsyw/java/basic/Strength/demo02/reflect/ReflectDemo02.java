package cn.llynsyw.java.basic.Strength.demo02.reflect;

import java.lang.reflect.Field;

/**
 * @ClassName ReflectDemo02
 * @Description
 * @package demo02.reflect
 * @Author luolinyuan
 * @Date 2021/7/26
 **/
public class ReflectDemo02 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        //0.获取Person的Class对象
        Class personClass=Person.class;
        //1.Field[]	getFields()	返回public的成员变量
        Field[] fields=personClass.getFields();
        for (Field field:fields){
            System.out.println(field);
        }
        System.out.println("==============");
        //2.指定名称的public成员变量
        Field a=personClass.getField("a");
        //获取成员变量a的值
        Person p=new Person("this is a");
        Object value=a.get(p);  //获取对象对应变量的值
        System.out.println(value);
        System.out.println("---------------------");

        //设置成员变量a的值
        a.set(p,"this is a changed a");
        System.out.println(p.a);
        System.out.println("---------------------");

        //Filed[] getDeclaredFields()获取所有成员变量不考虑修饰符
        Field[] declaredFileds=personClass.getDeclaredFields();
        for (Field field:declaredFileds){
            System.out.println(field);
        }

        //获取私有的成员变量d
        Field d = personClass.getDeclaredField("d");
        //忽略访问权限修饰符的安全检查
        d.setAccessible(true); //暴力反射
        d.get(p);   //获取对象p对应成员变量d


    }
}
