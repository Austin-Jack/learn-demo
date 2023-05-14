package cn.llynsyw.java.basic.day02.demo07;

import java.util.ArrayList;

/*
ArrayList当中常用的方法
public boolean add(E e):添加元素，其中元素为E类型
public E get(int index):根据索引返回对应位置元素
public E remove(int index):根据索引值从集合当中删除对应元素
public int size():获取集合的尺寸长度并返回
 */
public class Demo02ArrayListMethod {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        System.out.println(list);
        boolean success = list.add("LLY");//这里一定能添加成功，有些集合不能成功
        System.out.println("添加是否成功:" + success);
        list.add("htt");
        System.out.println(list.get(1));
        list.remove(1);
        System.out.println(list);
        System.out.println(list.size());


    }
}
