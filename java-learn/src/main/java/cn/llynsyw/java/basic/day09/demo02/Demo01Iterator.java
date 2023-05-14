package cn.llynsyw.java.basic.day09.demo02;

import java.util.ArrayList;
import java.util.Collection;//没有索引
import java.util.Iterator;///使用迭代器遍历集合

/*
迭代器的使用步骤：
1.使用集合中的方法iterator()获取迭代器的实现类对象，使用Iterator接口接收(多态)
2.使用Iterator接口中的方法hasNext()判断是否有下一个元素
3.使用Iterator接口中的方法next()取出集合中的下一个元素
 */
public class Demo01Iterator {
    public static void main(String[] args) {
        Collection<String> coll = new ArrayList<>();
        coll.add("唱");
        coll.add("跳");
        coll.add("篮球");
        coll.add("rap");

        Iterator<String> it = coll.iterator();//使用Iterator接口接收一个对象实现多态
        while (it.hasNext()) {
            System.out.println(it.next());//取出一个元素并将指针移动一位
        }

        System.out.println("=============");

        for(String i:coll){//foreach遍历   for(元素类型 变量名:数组/集合名称)
            System.out.println(i);
        }
    }
}
