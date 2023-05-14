package cn.llynsyw.design.pattern.exp.simpleFactory;
/*�����Ʒ��ɫ����Բ��*/
public class Circle implements Shape{
    @Override
    public void draw() {
        System.out.println("draw a circle");
    }

    @Override
    public void erase() {
        System.out.println("erase a circle");
    }
}
