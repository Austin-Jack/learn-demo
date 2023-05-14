package cn.llynsyw.java.curriculum.chapter7;

abstract class Shape {//������ ��״��
    abstract float Area();
    abstract void PrintArea();
}

class Rectangle extends Shape//�������� �̳���Shape��
{
    //�������Ϳ������
    int width;
    int length;
    //���췽�� ��ʼ�����Ϳ��ֵ
    public Rectangle(int newWidth,int newLength)
    {
        width=newWidth;
        length=newLength;
    }
    //ʵ�ָ���Area()�ĳ��󷽷�,���س����ε����
    float Area() {
        return width*length;
    }
    //ʵ�ָ���Area()�ĳ��󷽷�,��������ε����
    void PrintArea() {
        System.out.println("����һ������,�ҵ������"+ Area());
    }
}

class Circle extends Shape  //Բ���� �̳��ڳ�����shape��
{
    //����������
    final  float pi=3.14F;
    //�����뾶����
    int radius;
    //���췽��,��ʼ���뾶
    public Circle(int newRadius)
    {
        radius=newRadius;
    }
    //ʵ�ָ���ĳ��󷽷� ����Բ�ε����
    float Area()
    {
        return pi*radius*radius;
    }
    //ʵ�ָ���ĳ��󷽷� ���Բ�ε����
    void PrintArea()
    {
        System.out.println("����һ��Բ��,�ҵ������"+Area());
    }
}
class ChouXiang
{
    //������
    public static void main(String[] args) {
        //������������ʵ������s1�������Ϳ���ֵ3,4
        Rectangle s1=new Rectangle(3,4);
        //����Բ����ʵ������s2�����뾶����ֵΪ2
        Circle s2=new Circle(2);
        s1.PrintArea();
        s2.PrintArea();
    }
}