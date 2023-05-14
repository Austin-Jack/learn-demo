package cn.llynsyw.java.basic.day03.demo01;

import java.util.ArrayList;

public class Demo01ArrayListPrint {
    public static void main(String[] args) {
        ArrayList<String> str = new ArrayList<>();
        str.add("LLY");
        str.add("OPQ");
        str.add("RST");
        str.add("UBJW");
        str.add("opa");
        str.add("hhhh");
        arrayListPrint(str);


    }
//ArrayList方法返回的是集合中元素的个数
    public static void arrayListPrint(ArrayList s) {
        System.out.print("{" + s.get(0) + "@");
        for (int i = 1; i < s.size() - 2; i++) {
            System.out.print(s.get(i) + "@");
        }
        System.out.print(s.get(s.size()-1) + "}");
    }
}
