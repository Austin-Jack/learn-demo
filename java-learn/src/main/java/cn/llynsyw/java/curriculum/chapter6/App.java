package cn.llynsyw.java.curriculum.chapter6;

class Person {
    //������Ա���� ����name ���� age
    String name;
    private int age;

    //��������ĳ�Ա����
    public  boolean setAge(int newAge)
    {
        if(newAge>=5&&newAge<=20)
        {
            this.age=newAge;
            return true;
        }
        return false;
    }

    //��ȡ����ĳ�Ա����
    public int getAge()
    {
        return this.age;
    }

}

public class App {

    public static void main(String[] args) {
        Person s1=new Person();//����Personʵ������s1

        s1.name="����";//��s1���ָ�Ϊ����
        if(s1.setAge(25))
            System.out.println("����:"+s1.name+",����:"+s1.getAge()+"��");//��getAge()������ȡ����
        else
            System.out.println("�������");
    }
}
