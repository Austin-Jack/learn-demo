package cn.llynsyw.java.basic.Strength.demo02.reflect;

import java.io.*;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @ClassName ReflectTest
 * @Description
 * @package demo02.reflect
 * @Author luolinyuan
 * @Date 2021/7/26
 **/
public class ReflectTest {
    public static void main(String[] args) throws Exception {
        //1.创建Properties对象存放映射
        Properties pro=new Properties();
        //2.获取配置文件字节流
        //ClassLoader classLoader=ReflectTest.class.getClassLoader();//获取字节文件对应类加载器
        //InputStream is=classLoader.getResourceAsStream("pro.properties");//获取资源对应的字节流
        BufferedReader br=new BufferedReader(new FileReader("pro.properties"));
        //3.加载配置文件
        pro.load(br);   //从流中加载到集合

        //3.获取配置文件中定义的数据
        String className=pro.getProperty("className");
        String methodName=pro.getProperty("methodName");

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
