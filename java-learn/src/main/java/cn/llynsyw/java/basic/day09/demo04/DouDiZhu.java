package cn.llynsyw.java.basic.day09.demo04;

import java.util.ArrayList;

public class DouDiZhu {
    public static void main(String[] args) {
       ArrayList<String> MyPoker=Poker.assemble();
        //System.out.println(MyPoker);
        Poker.shufflePoker(MyPoker);
        //System.out.println(MyPoker);
        ArrayList<String> player01=new ArrayList<>();
        ArrayList<String> player02=new ArrayList<>();
        ArrayList<String> player03=new ArrayList<>();
        ArrayList<String> hand =new ArrayList<>();
        for (int i=0;i<54;i++){
            if (i>=51){
                hand.add(MyPoker.get(i));
            }
            else if (i%3==0){
                player01.add(MyPoker.get(i));
            }else if (i%3==1){
                player02.add(MyPoker.get(i));
            }else if (i%3==2){
                player03.add(MyPoker.get(i));
            }
        }
        System.out.println("玩家1"+player01.toString());
        System.out.println("玩家2"+player02.toString());
        System.out.println("玩家3"+player03.toString());
        System.out.println("底牌"+hand.toString());
    }
}
