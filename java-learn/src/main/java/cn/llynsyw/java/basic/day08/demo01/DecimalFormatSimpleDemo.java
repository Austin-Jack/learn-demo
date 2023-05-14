package cn.llynsyw.java.basic.day08.demo01;

import java.text.DecimalFormat;

public class DecimalFormatSimpleDemo {
    static  public void SimgleFormat(String pattern,double value)
    {
        DecimalFormat myFormat=new DecimalFormat(pattern);
        String output=myFormat.format(value);
        System.out.println(value+" "+pattern+" "+output);
    }

    public static void main(String[] args) {
        SimgleFormat("-###,###%",123564.23);
    }
}
