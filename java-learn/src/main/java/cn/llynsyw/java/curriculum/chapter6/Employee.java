package cn.llynsyw.java.curriculum.chapter6;

public class Employee {
    private String name;//����
    private int age;//����
    private double salary;//н��

    //���������Ĺ��췽��,���е������������Ĺ��췽����ʼ�������н��
    public Employee(String newName,int newAge,double newSalary)
    {
        this(newAge,newSalary);//�������������Ĺ��췽����ʼ�������н��
        System.out.println("���������Ĺ��췽��������");
        name=newName;
    }

    //���������Ĺ��췽��,���е���һ�������Ĺ��췽����ʼ��н��
    public Employee(int newAge,double newSalary)
    {
        this(newSalary);//�������������Ĺ��췽����ʼ��н��
        System.out.println("���������Ĺ��췽��������");
        age=newAge;
    }

    //һ�������Ĺ��췽��,���е����޲����Ĺ��췽��
    public Employee(double newSalary)
    {
        this();
        System.out.println("һ�������Ĺ��췽��������");
        salary=newSalary;
    }

    public Employee()
    {
        System.out.println("û�в����Ĺ��췽��������");
    }

    //���ó�Ա��������ĳ�Ա����
    void setAge(int newAge)
    {
        int age=0;
        this.age=newAge;
    }

    //��ȡ��Ա��������ĳ�Ա����
    int getAge()
    {
        return age;
    }

    //������
    public static void main(String[] args) {
        //����Employee��ʵ������s1���������������Ĺ��췽����ʼ������
        Employee s1=new Employee("����",30,8000);
        s1.setAge(31);
        System.out.println("������:"+s1.getAge());
    }
}
