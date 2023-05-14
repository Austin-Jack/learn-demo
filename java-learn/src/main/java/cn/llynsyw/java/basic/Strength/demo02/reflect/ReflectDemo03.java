package cn.llynsyw.java.basic.Strength.demo02.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @ClassName ReflectDemo03
 * @Description
 * @package demo02.reflect
 * @Author luolinyuan
 * @Date 2021/7/26
 **/
public class ReflectDemo03 {
    public static void main(String[] args) throws Exception {
        //0.��ȡPerson��Class����
        Class personClass=Class.forName("demo02.reflect.Person");
        //1.Constructor<T>	getConstructor(��<?>... parameterTypes)��ȡ������
        Constructor constructor = personClass.getConstructor(String.class, int.class);
        System.out.println(constructor);

        //2.��������
        Object person = constructor.newInstance("����", 23);
        System.out.println(person);
        Method eat_method=personClass.getMethod("eat");
        eat_method.invoke(person);


        System.out.println("------------");

        //ֱ��ͨ��Class�������newInstance()����ղζ���
        Object o=personClass.newInstance();
        System.out.println(o);
    }
}
