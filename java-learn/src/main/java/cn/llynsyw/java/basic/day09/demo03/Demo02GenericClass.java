package cn.llynsyw.java.basic.day09.demo03;

import cn.llynsyw.java.basic.day09.demo02.GenericClass;

public class Demo02GenericClass {
    public static void main(String[] args) {
        //不写泛型默认为Object类型
        cn.llynsyw.java.basic.day09.demo02.GenericClass gc = new cn.llynsyw.java.basic.day09.demo02.GenericClass();
        gc.setName("只能是字符串");
        Object obj = gc.getName();

        //创建GenericClass对象,泛型使用Integer类型
        cn.llynsyw.java.basic.day09.demo02.GenericClass<Integer> gc2 = new cn.llynsyw.java.basic.day09.demo02.GenericClass<>();
        gc2.setName(1);

        Integer name = gc2.getName();
        System.out.println(name);

        //创建GenericClass对象,泛型使用String类型
        cn.llynsyw.java.basic.day09.demo02.GenericClass<String> gc3 = new GenericClass<>();
        gc3.setName("小明");
        String name1 = gc3.getName();
        System.out.println(name1);
    }
}
