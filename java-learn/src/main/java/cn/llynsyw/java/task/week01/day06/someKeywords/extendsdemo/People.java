package cn.llynsyw.java.task.week01.day06.someKeywords.extendsdemo;

public class People {
    private String name;

    public void setName(String name){
        this.name=name;
    }

    public String getName(){
        return this.name;
    }
}

class Student extends People{
    public static void main(String[] args) {

        final Student stu=new Student();
        stu.setName("lly");//可以修改对象
        System.out.println(stu.getName());
    }
}
