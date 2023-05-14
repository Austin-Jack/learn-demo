package cn.llynsyw.java.basic.day04.demo05;

import java.util.ArrayList;
import java.util.Scanner;

public class Demo01RedPacket {
    public static void main(String[] args) {
        Manager manager = new Manager("群主", 1000);
        Member member1 = new Member("成员A", 20);
        Member member2 = new Member("成员B", 0);
        Member member3 = new Member("成员C", 10);
        Member member4 = new Member("成员D", 0);


        manager.show();
        member1.show();
        member2.show();
        member3.show();
        member4.show();

        System.out.println("==============");
        Scanner sc=new Scanner(System.in);
        int sendmoney;
        int sendCounts;
        System.out.print("请输入要发的红包总额与个数\n总额：");
        sendmoney=sc.nextInt();
        System.out.print("个数：");
        sendCounts=sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        list = manager.send(sendmoney, sendCounts);
        member1.receive(list);
        member2.receive(list);
        member3.receive(list);
        member4.receive(list);
        System.out.println("==============");
        manager.show();
        member1.show();
        member2.show();
        member3.show();


    }
}
