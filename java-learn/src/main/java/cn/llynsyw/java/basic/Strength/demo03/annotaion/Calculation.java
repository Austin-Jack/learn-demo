package cn.llynsyw.java.basic.Strength.demo03.annotaion;


/**
 * @ClassName Calculation
 * @Description 计算类
 * @package demo01.Junit
 * @Author luolinyuan
 * @Date 2021/7/25
 **/
public class Calculation {

    public int add(int a,int b){
        return a+b;
    }


    public int sub(int a,int b){
        return a-b;
    }
    @Check
    public void div(){
        System.out.println(1/0);
    }

    public void str(){
        String a=null;
        System.out.println(a.length());
    }
}
