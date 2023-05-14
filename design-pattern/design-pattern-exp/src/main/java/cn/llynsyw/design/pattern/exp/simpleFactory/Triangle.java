package cn.llynsyw.design.pattern.exp.simpleFactory;
/*�����Ʒ����������*/
public class Triangle implements Shape{
    @Override
    public void draw() {
        System.out.println("draw a triangle");
    }

    @Override
    public void erase() {
        System.out.println("erase a triangle");
    }
}
