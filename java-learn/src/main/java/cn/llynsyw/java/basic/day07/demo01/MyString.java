package cn.llynsyw.java.basic.day07.demo01;

import java.util.Date;

/*
【注意】
字符串一旦被创建就不能被改变
返回类型为字符串类型的是返回新的字符串
 */
public class MyString {
    public static void main(String[] args) {
        String str1="abcd";
        String str2="ABCD";
        String str3="  DC,  BA";
        System.out.println(str1.length());//获取长度，返回int值
        System.out.println(str1.indexOf("ac"));//获取参数第一次出现的位置返回其索引值int,若未找到返回-1，
        System.out.println(str1.lastIndexOf("c"));//获取参数最后一次出现的位置返回其索引值int，若未找到返回-1
        System.out.println(str2.charAt(3));//参数：索引值，获取索引值对应的字符并返回char类型
        System.out.println(str2.substring(2));//参数：获取起始索引值，获取起始索引值到结束的字符串返回String类型
        System.out.println(str2.substring(1,3));//参数：起始索引值，结束索引值，获取索引值之间的字符串返回String类型
        System.out.println(str3.trim());//去除前导和尾部空格，返回String类型
        System.out.println(str2.replace("AB","ef"));//将所有指定字符串替换为指定的字符串,如果target未出现返回原字符串，
        System.out.println(str2.startsWith("AB"));//判断字符串是否以参数值为起始的，返回boolean类型
        System.out.println(str3.endsWith("BA"));//判断字符串是否以参数值为结束的，返回boolean类型
        System.out.println(str1==str2);//a==b是判断两对象的地址值是否相同，返回boolean类型
        System.out.println(str1.equals(str1));//判断两字符串的内容是否完全相同，返回boolean类型
        System.out.println(str1.equalsIgnoreCase(str2));//判断两字符串在忽略大小写的前提下是否相同，返回boolean类型
        System.out.println(str1.compareTo(str2));//根据Unicode字符集比较序列顺序返回int值，只有在equals方法返回为true时，此方法才返回为0
        System.out.println(str2.toLowerCase());//将字符串转换为小写并返回String类型，若无改变返回原字符串,数字或非字符不影响
        System.out.println(str1.toUpperCase());//将字符串转换为大写并返回String类型，若无改变返回原字符串，数字或非字符不影响
        System.out.println(str3.split(",")[0]);//将字符串以参数为界限进行分割，并存放在一个String[]类型的数组中，另一种重载能限制分割次数
        System.out.println(str1.toCharArray()[0]);//将字符串转换为字符数组并返回char[]类型
        //System.out.println(String.format(format,args));//格式化字符串
        Date date=new Date();
        System.out.println(String.format("%tc",date));//将日期格式化输出
        // %te一个月的某一天(1~31) %tb月份简称，%tB月份全称，%tA星期几全称，%ta星期几简称，%tc包括全部日期和时间信息,%tY4位年份,%tj一年中的第几天，%tm月份，%td一月中的第几天，%ty2位年份...

        //正则表达式
        //定义E—mail地址的正则表达式：
        String regex="(\\p{Digit}){11}";

        String PhoneNumber="15736074835";
        System.out.println(regex.matches(PhoneNumber));
        System.out.println("===========");
        //字符串生成器，大大提高效率
        String str="";
        long startTime=System.currentTimeMillis();//记录起始时间
        for (int i = 0; i <10000 ; i++) {
            str=str+i;
        }
        long endTime=System.currentTimeMillis();//记录结束时间
        System.out.println("普通字符串消耗时间："+(endTime-startTime));
        StringBuilder builder=new StringBuilder("");//创造字符串生成器
        startTime=System.currentTimeMillis();//重新记录时间
        for (int j = 0; j <10000 ; j++) {
            builder.append(j);
        }
        endTime=System.currentTimeMillis();
        System.out.println("字符串生成器消耗时间："+(endTime-startTime));
        //字符串生成器常用方法
        //append(content);追加内容
        //insert(int offset arg)指定位置插入内容
        //delete(int start,int end)删除[  )区间内容







    }


}
