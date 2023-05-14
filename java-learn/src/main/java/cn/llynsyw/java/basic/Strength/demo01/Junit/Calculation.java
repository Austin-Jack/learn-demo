package cn.llynsyw.java.basic.Strength.demo01.Junit;


/**
 * @ClassName Calculation
 * @Description 计算类
 * @package demo01.Junit
 * @Author luolinyuan
 * @Date 2021/7/25
 **/
public class Calculation {
    private int a;
    private int b;
    public int add(int a,int b){
        return a+b;
    }

    public int sub(int a,int b){
        return a-b;
    }

    public Calculation() {
    }

    public Calculation(int a,int b){
        this.a=a;
        this.b=b;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

}
