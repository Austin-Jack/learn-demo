package cn.llynsyw.java.basic.Strength.demo03.annotaion;

/**
 * @ClassName AnnoDemo01
 * @Description
 * @package demo03.annotaion
 * @Author luolinyuan
 * @Date 2021/7/26
 **/
public class AnnoDemo01 {
    @Override
    public String toString() {
        return super.toString();
    }

    @Deprecated
    public void show1(){
        //有缺陷
    }

    @SuppressWarnings("all")
    public void show2(){

    }

    public void demo(){
        show1();

    }

}
