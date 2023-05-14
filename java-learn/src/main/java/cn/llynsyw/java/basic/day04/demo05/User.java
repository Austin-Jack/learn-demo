package cn.llynsyw.java.basic.day04.demo05;

//用户类
public class User {
    private String name;
    private int money;

    public User() {
    }
    public void show(){
        System.out.println("我是:"+name+",我有:"+money+"元");
    }

    public User(String name, int money) {
        this.name = name;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
