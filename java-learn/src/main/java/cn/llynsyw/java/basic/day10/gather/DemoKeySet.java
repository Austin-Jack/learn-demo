package cn.llynsyw.java.basic.day10.gather;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
1. 获取Map中所有的键，由于键是唯一的，所以返回一个Set集合存储所有的键。方法提示: keySet()
2. 遍历键的Set集合，得到每一个键。
3. 根据键，获取键所对应的值。方法提示: get(K key)
 */
public class DemoKeySet {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "ccc");
        map.put(2, "aaa");
        map.put(3, "aaa");
        Set<Integer> set = map.keySet();
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            Integer next = it.next();
            String s = map.get(next);
            System.out.println(next + "=" + s);
        }
        System.out.println("======================");
        for (Integer key : map.keySet()) {
            String s = map.get(key);
            System.out.println(key + "=" + s);
        }
    }
}
