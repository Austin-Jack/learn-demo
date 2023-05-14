package cn.llynsyw.java.curriculum.chapter6;

public class Student {
    //����Student��Ա���� ����name ����age
    String name;
    int age;

    //�޲ι��췽��
    public Student()
    {
        System.out.println("Student()���췽��������");
    }
    //ֻ��ʼ�������Ĺ��췽��
    public Student(String newName)
    {
        this.name=newName;
        System.out.println("Student(String newName)���췽��������");
    }
    //��ʼ������������Ĺ��췽��
    public Student(String newName,int newAge)
    {
        this.name=newName;
        this.age=newAge;
        System.out.println("Student(String newName,int newAge)���췽��������");
    }

    //������
    public static void main(String[] args) {
        Student s1=new Student();//����Studentʵ������s1,���������
        Student s2=new Student("����");//����Studentʵ������s2,ֻ��������
        Student s3=new Student("����",15);//����Studentʵ������s3,��������������
    }
}
