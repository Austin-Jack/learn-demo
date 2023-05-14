package cn.llynsyw.java.curriculum.chapter6;

class Ca {
    int a;
    static int b;//����һ����̬��������b

    //��̬����m1()
    public static void m1()
    {
        //a=10; //���Ը��Ǿ�̬���Ը�ֵʧ��
        new Ca().a=10;
        b=10;
    }
    //ʵ������m2()
    public void m2()
    {
        a=5;
        b=5;
    }
    public static void m3()
    {
        //����m1()����
        m1();
        //m2();  //���Ե���ʵ������m2()ʧ��
    }
}
class Cb
{
    //������
    public static void main(String[] args) {
        //����Caʵ������s1,s2

        Ca s1=new Ca();
        Ca s2=new Ca();
        Ca.b=5;//ͨ����ֱ�Ӹ���̬���Ը�ֵ
        s1.b=6;//ͨ���������̬���Ը�ֵ
        s2.b=7;
        //��ʾCa.b��ֵ
        System.out.println("Ca.b="+Ca.b);
        //��ʾs1.b��ֵ
        System.out.println("s1.b="+s1.b );
        //��ʾs2.b��ֵ
        System.out.println("s2.b="+s2.b);
    }
}