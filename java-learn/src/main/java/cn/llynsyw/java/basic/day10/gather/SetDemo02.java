package cn.llynsyw.java.basic.day10.gather;

import cn.llynsyw.java.basic.day10.demo02.Person;

import java.util.*;

//Set集合是Collection接口的实现类,其特点是无序性,元素唯一性,保证这一特性依赖于hashCode() 和 equals()方法
//Collection接口包括 add(E e) remove(Object o) isEmpty()  iterator() size()常用方法
//Set接口常用两个实现类   常用方法
// HashSet
//TreeSet      fist()返回此Set集合的第一个元素  last()  comparator返回比较器,若为自然顺序则返回null
//              headSet(E toElement)返回toElement之前所有对象的一个新的Set集合  subSet()截取集合并返回 tailSet()返回参数之后的所有对象
public class SetDemo02 {
    public static void main(String[] args) {
        dem01();
    }

    private static void dem01() {
        //show01();
        // show02();
        show03();


    }

    private static void show03() {
//        数组+链表(红黑树)+链表 保证了顺序,且元素的唯一性
        LinkedHashSet<String> set=new LinkedHashSet<>();
        set.add("aaa");
        set.add("ccc");
        set.add("bbb");
        set.add("ccc");
        System.out.println(set);

    }

    private static void show02() {
        HashSet<cn.llynsyw.java.basic.day10.demo02.Person> set=new HashSet<>();
        set.add(new cn.llynsyw.java.basic.day10.demo02.Person("LLY",20));
        set.add(new cn.llynsyw.java.basic.day10.demo02.Person("aaa",22));
        set.add(new cn.llynsyw.java.basic.day10.demo02.Person("aaa",22));
        set.add(new cn.llynsyw.java.basic.day10.demo02.Person("bbb",21));
        System.out.println(set);

    }

    private static void show01() {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(1);
        set.add(3);
        set.add(2);
        set.add(5);
        set.add(1);
        System.out.println("第一个元素:" + set.first() + "\n最后一个元素:" + set.last() + "\nSet集合大小:" + set.size() + "\n默认递增排序集合为:" + set);
        // 第一个元素:1
        //最后一个元素:5
        //Set集合大小:4
        //集合为:[1, 2, 3, 5]
        // 说明Set集合元素的唯一性
        //TreeSet会自然顺序递增排序
//        储存自定义类型时按照CompareTo()函数进行排序

        TreeSet<cn.llynsyw.java.basic.day10.demo02.Person> set2=new TreeSet<>();
        set2.add(new cn.llynsyw.java.basic.day10.demo02.Person("LLY",20));
        set2.add(new cn.llynsyw.java.basic.day10.demo02.Person("aaa",22));
        set2.add(new cn.llynsyw.java.basic.day10.demo02.Person("aaa",22));
        set2.add(new Person("bbb",21));
        System.out.println(set2);
    }
}
