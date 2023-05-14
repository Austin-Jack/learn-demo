package cn.llynsyw.java.task.week01.day04;

public class Car {

    /*属性*/
    private String wheel;//轮子

    public String getWheel() {
        return wheel;
    }

    public void setWheel(String wheel) {
        this.wheel = wheel;
    }

    public String getHeadlights() {
        return headlights;
    }

    public void setHeadlights(String headlights) {
        this.headlights = headlights;
    }

    private String headlights;//车灯

    /* 外部接口*/
    public void carFunction() { //功能
        System.out.println("我是车,我能跑");
    }

    public static void main(String[] args) {
        new Car().carFunction();
    }

}

/*房车类继承车类*/
class Rv extends Car {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void rvFunction() {
        carFunction(); //继承而来的
        setName("房车");
        System.out.println("我是" + getName() + "我能提供睡觉");
    }

    @Override
    public void carFunction() {
        setName("房车");
        System.out.println("我是"+getName()+"我能提供睡觉");
    }

    public static void main(String[] args) {
        Car car=new Rv(); //父类引用指向子类对象
        car.carFunction();//只能调用父类中声明的方法
    }

}