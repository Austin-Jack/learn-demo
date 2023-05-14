package cn.llynsyw.java.basic.day10.gather;

import java.util.HashMap;
import java.util.Map;

/*
public V put(K key, V value) : 把指定的键与指定的值添加到Map集合中。
public V remove(Object key) : 把指定的键 所对应的键值对元素 在Map集合中删除，返回被删除元素的
值。
public V get(Object key) 根据指定的键，在Map集合中获取对应的值。
public Set<K> keySet() : 获取Map集合中所有的键，存储到Set集合中。
public Set<Map.Entry<K,V>> entrySet() : 获取到Map集合中所有的键值对对象的集合(Set集合)。
 */
public class MapDemo {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1,"ccc");
        map.put(2,"aaa");
        map.put(3,"aaa");
        String v = map.put(1, "aaa");
        System.out.println("v:"+v);//v:ccc,已存在键值，返回被替换的值
        String s = map.get(1);
        System.out.println("s:"+s);
        System.out.println("是否包含键值3:"+map.containsKey(3));
        System.out.println("是否包含值“aaa”:"+map.containsValue("aaa"));
        String remove = map.remove(1);
        System.out.println("移除键值1所对应的元素:"+remove);

    }
}
