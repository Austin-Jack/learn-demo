package cn.llynsyw.java.curriculum.chapter5;

public class MyObjectA {

    public static void main(String[] args) {
        //����Student��ʵ������s1
        Student s1=new Student();

        s1.setStudent("����",13,80,90,85);//����s1��setStudent()�������ó�Ա����ֵ

        //�����ʾs1����Ա�������ֺܷ�ƽ����
        System.out.println("���,�ҽ�"+s1.name+","+"�ҽ���"+s1.age+"��");
        System.out.println("�ҵ��ܷ���"+s1.total());
        System.out.println("�ҵ�ƽ������"+s1.average());
    }
}
