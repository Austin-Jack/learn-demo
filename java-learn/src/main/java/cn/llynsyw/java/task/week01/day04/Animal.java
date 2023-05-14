package cn.llynsyw.java.task.week01.day04;

public class Animal {
    public void cat(){
        System.out.println("Animal");
    }

    public static void main(String[] args) {
        Animal animal=new ChineseCat();
        animal.cat();
    }
}

class Cat extends Animal{
    @Override
    public void cat() {
        System.out.println("cat");
    }
}

class ChineseCat extends Cat{
    @Override
    public void cat() {
        System.out.println("ChineseCat");
    }
}