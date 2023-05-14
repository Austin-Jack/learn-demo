package cn.llynsyw.java.basic.day02.demo07;

import java.util.ArrayList;

/*
如果希望向ArryList当中存储基本类型数据，必须使用基本类型对应的包装类
基本类型    包装类（引用类型，包装类都位于java.lang包下）
byte        Byte
short       Short
int         Integer
long        Long
float       Float
double      Double
char        Character
boolean     Boolean
 */
public class Demo03ArrayListBasic {
    public static void main(String[] args) {
        ArrayList<Integer> intlist=new ArrayList<>();
        intlist.add(1);
        System.out.println(intlist);
    }
}
