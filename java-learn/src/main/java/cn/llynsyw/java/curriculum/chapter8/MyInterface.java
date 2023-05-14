package cn.llynsyw.java.curriculum.chapter8;
import java.text.DecimalFormat; //����DecimalFormat��
interface  Shape //Shape��
{
    float pi=3.14F; //������
    double area();  //����ͼ�ε����
    double volume();//����ͼ�ε����
}

class Cylinder implements Shape //ʵ��Shape�ӿ�
{
    private double radius;//����뾶
    private int height;//Բ�����

    public Cylinder(double r,int h)//��Cylinder���췽��
    {
        radius=r;
        height=h;
    }

    //ʵ�ֽӿ�Shape��area()����,����Բ����������
    public double area() {
        return pi*radius*radius;
    }

    //ʵ�ֽӿ�Shape��volume()����������Բ��������
    public double volume()
    {
        return area()*height;
    }
}

public class MyInterface {

    //������
    public static void main(String[] args) {

        //����Cylinder��Զ���Ϊ����뾶Ϊ2����Ϊ3
        Cylinder a=new Cylinder(2,3);
        DecimalFormat myFormat=new DecimalFormat("0.00"); //���ø�ʽ���

        //����a.area����������myFormatָ����ʽ���Բ�������
        System.out.println("Բ����ĵ�����ǣ�"+myFormat.format(a.area()));

        //����a.area����������myFormatָ����ʽ���Բ�������
        System.out.println("Բ����������:"+myFormat.format(a.volume()));
    }
}
