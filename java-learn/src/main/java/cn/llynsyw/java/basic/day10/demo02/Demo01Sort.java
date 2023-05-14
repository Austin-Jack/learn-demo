package cn.llynsyw.java.basic.day10.demo02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Demo01Sort {
    public static void main(String[] args) {
        ArrayList<Person> p=new ArrayList<>();
        p.add(new Person("LLY",20));
        p.add(new Person("aaa",25));
        p.add(new Person("bbb",22));
        //对自定义类型的集合进行排序需要将该类对Comparable接口进行实现，并重写CompareTo方法
        System.out.println(p);
        Collections.sort(p, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
//                return o1.getAge()-o2.getAge();//按照年龄升序
                return o2.getAge()-o1.getAge(); //按照年龄降序
            }
        });
        System.out.println(p);
    }
}
