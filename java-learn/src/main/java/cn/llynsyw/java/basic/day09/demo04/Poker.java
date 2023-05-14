package cn.llynsyw.java.basic.day09.demo04;

import java.util.ArrayList;
import java.util.Collections;

public class Poker {

    public static ArrayList<String> assemble() {
        ArrayList<String> poker = new ArrayList<>();
        String[] colors = new String[]{"♥", "♠", "♣", "♦"};
        String[] numbers = new String[]{"2", "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3"};
        poker.add("大王");
        poker.add("小王");
        for (String c : colors) {
            for (String num:numbers){
                poker.add(c+num);
            }
        }
        return poker;
    }

    public static void shufflePoker(ArrayList<String> p){
        Collections.shuffle(p);
    }


}
