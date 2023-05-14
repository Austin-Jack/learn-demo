package cn.llynsyw.java.curriculum.chapter5;

public class MyObject {

    public static void main(String[] args) {
        Student s1=new Student();//����Student ʵ��������s1
        //��ʼ��S1����Ա����
        s1.name="����";
        s1.age=13;
        s1.chinese=80;
        s1.math=90;
        s1.english=85;
        //��ʾ���s1.��Ա������Ӧֵ���ֺܷ�ƽ����
        System.out.println("��ã��ҽ�"+s1.name+","+"�ҽ���"+s1.age+"��");
        System.out.println("�ҵ��ܷ���"+s1.total());
        System.out.println("�ҵ�ƽ������"+s1.average());

        //����Student ʵ��������s2
        Student s2=new Student();
        //��ʼ��s2����Ա����
        s2.name="����";
        s2.age=12;
        s2.chinese=80;
        s2.math=90;
        s2.english=90;
        //��ʾ���s2.��Ա������Ӧֵ���ֺܷ�ƽ����
        System.out.println("��ã��ҽ�"+s2.name+","+"�ҽ���"+s2.age+"��");
        System.out.println("�ҵ��ܷ���"+s2.total());
        System.out.println("�ҵ�ƽ������"+s2.average());

        //�ж�s1��s2�ָܷߵ�
        if(s1.total()>s2.total())
            System.out.println(s1.name+"�ĳɼ���");
        else if(s1.total()<s2.total())
            System.out.println(s2.name+"�ĳɼ���");
        else
            System.out.println(s1.name+"��"+s2.name+"�ĳɼ�һ��");

    }
}
