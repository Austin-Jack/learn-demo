package cn.llynsyw.design.pattern.exp.simpleFactory;

public class Rectangle implements Shape{
    @Override
    public void draw() {
        System.out.println("draw a rectangle");
    }

    @Override
    public void erase() {
        System.out.println("erase a rectangle");
    }
}
