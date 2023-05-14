package cn.llynsyw.java.basic.day10.gather;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Demo01MapTest {
    public static void main(String[] args) {
        //1.获取字符串对象
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入一个字符串:");
        String string=sc.next();
        //2.装入Map集合中
        HashMap<Character,Integer> map=new HashMap<>();
        for (Character c:string.toCharArray()){
            if (map.containsKey(c)){
                Integer value = map.get(c);
                value++;
                map.put(c,value);
            }else {
                map.put(c,1);
            }
        }
        for (Map.Entry<Character,Integer> entry:map.entrySet()){
            Character key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println("字符\""+key+"\"出现次数:"+value);
        }
    }
}
