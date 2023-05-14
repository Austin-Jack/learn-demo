package cn.llynsyw.java.basic.day10.gather;//List集合是Collection接口的实现类
//Collection接口包括 add(E e) remove(Object o) isEmpty()  iterator() size()常用方法
//        List接口新增了get(int index)  set(int index,Object obj) 方法

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListDemo01 {
    public static void main(String[] args) {
//        list01();
        list02();
    }

    private static void list02() {
        LinkedList<String> list = new LinkedList<>();
        //LinkedList集合增删快,随机访问查询慢,因为有链表结构,有序的
//        public void addFirst(E e) :将指定元素插入此列表的开头。
//        public void addLast(E e) :将指定元素添加到此列表的结尾。
//        public E getFirst() :返回此列表的第一个元素。
//        public E getLast() :返回此列表的最后一个元素。
//        public E removeFirst() :移除并返回此列表的第一个元素。
//        public E removeLast() :移除并返回此列表的最后一个元素。
//        public E pop() :从此列表所表示的堆栈处弹出一个元素。
//        public void push(E e) :将元素推入此列表所表示的堆栈。
//        public boolean isEmpty() ：如果列表不包含元素，则返回true。
        list.add("a");
        list.add("c");
        list.add("d");
        list.add("d");
        list.add("f");
        list.add("g");
        list.push("推入栈的一个元素");
        int count=0;
        for (String i : list) {
            System.out.println("第"+count+"号元素:"+i);
            count++;
        }
        //弹出栈顶元素,既是取除
        while (!list.isEmpty())
        System.out.println("弹出一个元素:"+list.pop());
        System.out.println("弹出后是否为空:"+list.isEmpty());


    }

    private static void list01() {

        List<String> list = new ArrayList<>();
//        ArrayList实现类的特点,随机访问查询快(有序,有索引值) 增删慢
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println(list);
        int i = (int) (Math.random() * list.size());
        System.out.println("随机访问获取的值为:" + list.get(i));
        System.out.println("删除这个随机的元素并将其返回:" + list.remove(i));
//        遍历方法 for循环,增强for
        System.out.println("================");
        for (int j = 0; j < list.size(); j++) {
            System.out.println(list.get(j));
        }
        System.out.println("================");
        for (String j : list) {
            System.out.println(j);
        }

    }
}
