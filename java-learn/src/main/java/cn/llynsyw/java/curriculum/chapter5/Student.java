package cn.llynsyw.java.curriculum.chapter5;

public class Student {
    //声明Student成员变量
    String name;
    int age;
    int chinese;
    int math;
    int english;

    //求和成员方法用以返回语数外三科成绩总和
    int total(){
        return chinese+math+english;
    }
    //求平均值成员方法用以返回语数外三科成绩平均值
    int average(){
        return  total()/3;
    }

    //用于设置Student对象成员变量值的成员方法
    void setStudent(String n,int a,int c,int m,int e)
    {
        name=n;
        age=a;
        chinese=c;
        math=m;
        english=e;
    }
}
