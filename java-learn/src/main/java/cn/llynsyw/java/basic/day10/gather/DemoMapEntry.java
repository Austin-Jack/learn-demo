package cn.llynsyw.java.basic.day10.gather;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
1. 获取Map集合中，所有的键值对(Entry)对象，以Set集合形式返回。方法提示: entrySet() 。
2. 遍历包含键值对(Entry)对象的Set集合，得到每一个键值对(Entry)对象。
3 . 通过键值对(Entry)对象，获取Entry对象中的键与值。 方法提示: getkey() getValue()
 */
public class DemoMapEntry {
    public static void main(String[] args) {
        Map <Integer,String> map=new HashMap<>();
        map.put(1,"ccc");
        map.put(2,"aaa");
        map.put(3,"aaa");

        Set<Map.Entry<Integer, String>> set = map.entrySet();
        Iterator<Map.Entry<Integer, String>> it = set.iterator();
        while (it.hasNext()){
            Map.Entry<Integer, String> entry = it.next();
            Integer key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key+"="+value);
        }
        System.out.println("=======================");
        for (Map.Entry<Integer,String> entry:map.entrySet()){
            Integer key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key+"="+value);
        }
    }
}
