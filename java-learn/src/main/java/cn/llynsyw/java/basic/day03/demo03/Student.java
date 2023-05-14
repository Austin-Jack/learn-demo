package cn.llynsyw.java.basic.day03.demo03;

public class Student {
    private static int room;//静态数据
    private String name;
    private int Age;

    static {
        room=101;
    }

    public static int getRoom() {
        return room;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }
}
