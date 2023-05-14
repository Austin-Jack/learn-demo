package cn.llynsyw.java.basic.day04.demo05;

import java.util.ArrayList;

public class Manager extends User {
    public Manager(String name, int money) {
        super(name, money);
    }

    public ArrayList<Integer> send(int sendMoney, int sendCounts) {
        ArrayList<Integer> list = new ArrayList<>();
        int before = this.getMoney();//先查看发放前的余额
        int end = before - sendMoney;
        if (end >= 0 && sendCounts > 0) {
            int avg = sendMoney / sendCounts;//平均没人能得得钱
            int mod = sendMoney % sendCounts;//多出来的零头
            //System.out.println("发放前余额：" + before + "元");
            System.out.println(getName() + "发了" + sendCounts + "个红包,总额：" + sendMoney + "元");
            for (int i = 0; i < sendCounts - 1; i++) {//将发放个数-1 个红包放入相等的钱
                list.add(avg);
            }
            list.add(avg + mod);//将最后一个红包多放零头的钱
            setMoney(getMoney() - sendMoney);//重新设置余额
            return list;
        } else if (end < 0) {
            System.out.println("余额不足");
            return null;
        } else if (sendCounts <= 0) {
            System.out.println("发送个数至少为1");
            return null;
        }
        return list;
    }

}
