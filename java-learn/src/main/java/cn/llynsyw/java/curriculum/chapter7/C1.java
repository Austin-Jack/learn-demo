package cn.llynsyw.java.curriculum.chapter7;

class PersonA {
    //����˽������name
    private String name;

    //�÷�����������˽������name��ֵ
    public void setName(String newName)
    {
        name=newName;
    }
    //�÷������ڻ�ȡ˽������name��ֵ
    public String getName(){
        return name;
    }
}
class StudentA extends PersonA
{
    //����˽������department
    private String department;

    //�÷�����������˽������department��ֵ
    public void setDepartment(String newDepartment)
    {
        department=newDepartment;
    }
    //�÷������ڻ�ȡ������department
    public String getDepartment()
    {
        return department;
    }

}

public class C1
{
    public static void main(String[] args) {
        StudentA s1=new StudentA();
        s1.setName("����");//����setName����,�������"����"
        s1.setDepartment("�����ϵ");//����setDepartment����,�������"�����ϵ"
        System.out.println("���,�ҽ�"+s1.getName());//��ʾs1������
        System.out.println("����"+s1.getDepartment());//��ʾs1��ϵ��

    }
}