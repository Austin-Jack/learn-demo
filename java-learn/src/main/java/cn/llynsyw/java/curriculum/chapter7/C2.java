package cn.llynsyw.java.curriculum.chapter7;

class PersonB {
    String name;
    int age;
    //�޲ι��췽��
    public PersonB()
    {
        System.out.println("PersonB()������");
    }
    //���ι��췽��,������name��ֵ
    public PersonB(String newName)
    {
        name=newName;
        System.out.println("Person(String newName)������");
    }
    //�÷���������ʾname��age��ֵ
    public void introduce()
    {
        System.out.println("����"+name+",����"+age+"��");
    }
}

class StudentB extends PersonB
{
    //�޲ι��췽��
    public StudentB()
    {
        System.out.println("StudentB()����������");
    }
    public StudentB(String newName,int newAge)
    {
        super(newName);//���ø�����ι��췽��������newName
        age=newAge;
    }
}
public class C2
{
    //������
    public static void main(String[] args) {
        //����StudentB��ʵ������s1,s2
        StudentB s1=new StudentB();
        StudentB s2 =new StudentB("����",19);
        s2.introduce();//����s2.introduce����
    }
}
