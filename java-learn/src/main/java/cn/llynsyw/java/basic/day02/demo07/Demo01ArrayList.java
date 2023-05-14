package cn.llynsyw.java.basic.day02.demo07;

import java.util.ArrayList;

public class Demo01ArrayList {
    public static void main(String[] args) {
        ArrayList<String> str = new ArrayList<>();
        System.out.println(str);//这里直接打印，并没有装入任何内容，则会出现[]，并不是null
        str.add("a");//加入东西
        str.add("b");
        System.out.println(str);//再次打印就会显示
    }
}
