package cn.llynsyw.java.basic.day04.demo05;

import java.util.ArrayList;
import java.util.Random;

public class Member extends User {
    public Member(String name, int money) {
        super(name, money);
    }

    public void receive(ArrayList<Integer> list) {
        if (list.isEmpty()) {
            System.out.println("系统：很可惜" + getName() + "，你来晚了红包已经抢完了");
        } else {
            Random r = new Random();
            //随机获取一个红包个数范围内的索引值
            int index = r.nextInt(list.size());
            //根据这个索引值获取拿取红包
            Integer getMoney = list.remove(index);
            System.out.println("我是：" + getName() + "，我抢了：" + getMoney + "元钱的红包");
            setMoney(getMoney + getMoney());

            if (list.isEmpty()) {
                System.out.println("系统：红包已经被抢完了");
            } else {
                int leftMoney = 0;
                for (int i = 0; i < list.size(); i++) {
                    leftMoney += list.get(i);
                }
                System.out.println("系统：现在还剩余" + list.size() + "个红包，总额:" + leftMoney + "元");
            }
        }
    }

}
