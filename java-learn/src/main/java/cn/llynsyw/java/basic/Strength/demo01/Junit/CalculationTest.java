package cn.llynsyw.java.basic.Strength.demo01.Junit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

/**
 * @ClassName CalculationTest
 * @Description Test the calculation class
 * @package demo01.Junit
 * @Author luolinyuan
 * @Date 2021/7/25
 **/
public class CalculationTest {
    Calculation c=null;
    @Before
    public void init(){
        System.out.println("init....");
        Random random=new Random();
        int a=random.nextInt(100) ;
        int b=random.nextInt(100);
        c=new Calculation(a,b);
    }

    @Test
    public void testAdd(){
        //1.创建对象
        //2.调用测试方法
        System.out.println(c.getA());
        System.out.println(c.getB());
        int result=c.add(c.getA(),c.getB());
        System.out.println("testAdd....");
        //3.断言
        //Assert.assertEquals(3,result);


    }

    @Test
    public void testSub(){
        System.out.println(c.getA());
        System.out.println(c.getB());
        int result=c.sub(c.getA(),c.getB());
        System.out.println("testSub....");
        //Assert.assertEquals(-1,result);
    }

    @After
    public void close(){
        System.out.println("close....");
    }
}
