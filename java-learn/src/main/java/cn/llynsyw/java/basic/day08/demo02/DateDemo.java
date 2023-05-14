package cn.llynsyw.java.basic.day08.demo02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DateDemo {
    public static void main(String[] args) throws ParseException {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入您的出生日期，格式：yyyy-MM-dd");
        String birthdayString=sc.next();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(birthdayString);
        long birthday=date.getTime();
        long now=new Date().getTime();
        System.out.println("你至今已经活了"+(now-birthday)/1000/60/60/24+"天了");
    }
}
