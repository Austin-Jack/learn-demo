package cn.llynsyw.java.basic.day06.demo04;

/*
红包发出去之后，所有人抢完了，最后一个留给群主
填空:
1.设置程序标题，通过构造方法的字符串参数
2.设置群主名称
3.设置分发策略:平均，还是随机？

策略:
1.普通红包(平均):totalMoney/totalCount,余数放在最后一个红包当中.
2.手气红包(随机):最少一分钱，最多不超过平均数的2倍
 */
public class Bootstrap {
    public static void main(String[] args) {
        MyRed red=new MyRed("红包程序");
        red.setOwnerName("LLY");
        
    }
}
