package cn.llynsyw.java.basic.summary.demo08;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class ProDemo2 {
    public static void main(String[] args) throws IOException {
        //创建属性集对象
        Properties properties=new Properties();
        //加载文本信息到属性集
        properties.load(new FileInputStream("read.txt"));
        //遍历集合并打印
        Set<String> keys=properties.stringPropertyNames();
        for (String key:keys){
            System.out.println(key+"-->"+properties.getProperty(key));
        }

    }
}
