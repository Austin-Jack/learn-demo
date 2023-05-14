package cn.llynsyw.java.curriculum.chapter8;

interface Achievement //�ӿ�Achievement
{
    float average(); //����ƽ��ֵ
}
class Person  //Person��
{
    String name;//����
    int age;//����

    //Person�๹�췽��
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //�÷�������������ֺ�����
    public void introduce()
    {
        System.out.println("��ã����ǣ�"+name+"���꣺"+age+"��");
    }
}

class Student extends Person implements Achievement
{
    int Chinese; //���ĳɼ�
    int Math;    //��ѧ�ɼ�
    int English; //Ӣ��ɼ�
    public Student(String newName,int newAge)
    {
        //���ø���Ĺ��췽��
        super(newName,newAge);
    }

    //�÷��������������������Ƴɼ�
    public void setScore(int c,int m,int e)
    {
        Chinese=c;
        Math=m;
        English=e;
    }

    //�÷����Ż�������������ƽ��ֵ
    public float average()
    {
        return (Chinese+Math+English)/3;
    }
}
public class MyInterface_2 {
    //������
    public static void main(String[] args) {
        Student s1=new Student("����",16);

        s1.introduce();//����introduce�����������������
        s1.setScore(80,90,80);//����setScore�����������Ƴɼ�
        System.out.println("ƽ����Ϊ:"+s1.average());//��ʾ���s1��ƽ����
    }
}
