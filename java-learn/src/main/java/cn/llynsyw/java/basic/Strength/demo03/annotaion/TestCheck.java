package cn.llynsyw.java.basic.Strength.demo03.annotaion;


import org.junit.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName TestCheck
 * @Description 简单的测试框架
 * @package demo03.annotaion
 * @Author luolinyuan
 * @Date 2021/7/26
 **/

public class TestCheck {
    //当主方法执行后，会自动执行被@Check标记的所有方法
    public static void main(String[] args) throws IOException {
        //1.创建计算器对象
        Calculation c = new Calculation();
        //2.获取字节码文件对象
        Class cls = c.getClass();
        //3.获取所有方法
        Method[] methods = cls.getDeclaredMethods();

        int num = 0;
        BufferedWriter bw = new BufferedWriter(new FileWriter("bug.txt",true));

        for (Method method : methods) {
            //4.判断方法上是否有Check注解
            if (method.isAnnotationPresent(Check.class)) {
                //5.有就执行
                try {
                    method.invoke(c);
                } catch (Exception e) {
                    //6.捕获异常,写入日志
                    num++;
                    bw.write(method.getName() + "---方法出现了异常");
                    bw.newLine();                                   //不带包名的异常
                    bw.write("异常的名称：" + e.getCause().getClass().getSimpleName());
                    bw.newLine();
                    bw.write("异常的原因：" + e.getCause().getMessage());
                    bw.newLine();
                }
            }
        }
        bw.write("本次测试一共出现" + num + "次异常");
        bw.newLine();
        bw.write(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z").format(new Date(System.currentTimeMillis())));
        bw.newLine();
        bw.write("---------------------------");
        bw.newLine();
        bw.flush();
        bw.close();
    }
}
