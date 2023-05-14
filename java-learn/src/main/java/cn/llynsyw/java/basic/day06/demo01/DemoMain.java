package cn.llynsyw.java.basic.day06.demo01;

public class DemoMain {
    public static void main(String[] args) {
        Computer computer=new Computer();
        computer.powerOn();

        computer.useDevice(new Keyboard());
        computer.useDevice(new Mouse());


        computer.powerOff();
    }
}
