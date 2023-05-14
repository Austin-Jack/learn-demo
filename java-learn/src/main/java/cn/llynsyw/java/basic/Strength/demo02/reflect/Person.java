package cn.llynsyw.java.basic.Strength.demo02.reflect;

/**
 * @ClassName Person
 * @Description
 * @package demo02.reflect
 * @Author luolinyuan
 * @Date 2021/7/25
 **/
public class Person {
    private  String name;
    private int age;

    public String a;
    protected String b;
    String c;
    private String d;


    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", a='" + a + '\'' +
                ", b='" + b + '\'' +
                ", c='" + c + '\'' +
                ", d='" + d + '\'' +
                '}';
    }

    public void eat(){
        System.out.println("eat....");
    }

    public void eat(String food){
        System.out.println("eat"+food+"...");
    }

    public Person(String a) {
        this.a = a;
    }

    private void test(){

    }
}
