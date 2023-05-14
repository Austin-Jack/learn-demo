package cn.llynsyw.java.curriculum.chapter7;

class Animal
{
    //�÷���Ϊ����play()����
    void  play()
    {
        System.out.println("���Ƕ���,�һ�ܶ౾��");
    }
}

class Bird extends Animal
{
    //�÷���������д����Animal��play����
    void  play()
    {
        System.out.println("����С��,�һ����");
    }
}

class Fish extends Animal
{
    //�÷���������д����Animal��play����
    void play()
    {
        System.out.println("����С��,������Ӿ");
    }
}
class Overriding
{
    //������
    public static void main(String[] args)
    {
        Animal s1=new Animal();//����Animal���ʵ������s1
        Bird s2=new Bird();//����Bird���ʵ������s2
        Fish s3=new Fish();//����Fish���ʵ������s3
        //�ֱ����s1,s2,s3��play()����
        s1.play();
        s2.play();
        s3.play();
    }
}