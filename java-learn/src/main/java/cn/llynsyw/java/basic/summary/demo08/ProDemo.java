package cn.llynsyw.java.basic.summary.demo08;

import java.util.Properties;
import java.util.Set;

public class ProDemo {
    public static void main(String[] args) {
        //创建属性集对象
        Properties properties=new Properties();
        //添加键值对元素
        properties.setProperty("filename","a.txt");
        properties.setProperty("length","4028");
        properties.setProperty("location","D:\\a.txx");
        //打印属性集对象
        System.out.println(properties);
        //通过键值对,获取属性
        System.out.println(properties.getProperty("filename"));
        System.out.println(properties.getProperty("length"));
        System.out.println(properties.getProperty("location"));

        //遍历打印键值对
        Set<String> keys=properties.stringPropertyNames();
        for (String key:keys){
            System.out.println(key+"-----"+properties.getProperty(key));
        }
    }
}
