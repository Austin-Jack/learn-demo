package cn.llynsyw.java.basic.Strength.demo03.annotaion;

import java.lang.reflect.Method;

/**
 * @ClassName ReflectTest
 * @Description
 * @package demo02.reflect
 * @Author luolinyuan
 * @Date 2021/7/26
 **/
@pro(className = "demo03.annotaion.Demo02",methodName = "show")
public class ReflectTest {
    public static void main(String[] args) throws Exception {
        //1.解析注解
        //1.1获取该类的字节码对象
        Class<ReflectTest> reflectTestClass = ReflectTest.class;
        //2.获取上边的注解对象
            //其实就是在内存中生成了该注解接口的子类实现对象
        /*
            public class ProImpl implements Pro{
            public String className(){
                return "demo03.annotaion.Demo01";
            }

            public String methodName(){
                return "show";
            }
         */
        //这行代码自动完成上述代码
        pro an = reflectTestClass.getAnnotation(pro.class);
        //3.调用注解中定义的抽象方法,获取返回值
        String className = an.className();
        String methodName=an.methodName();

        //4.加载该类进内存
        Class cls = Class.forName(className);
        //4.创建对象
        Object obj=cls.newInstance();
        //5.获取方法对象
        Method method=cls.getMethod(methodName);
        //6.执行方法
        method.invoke(obj);

    }
}
