package cn.llynsyw.java.curriculum.review.chapter3;

public class Person {
    public String name; //����
    public MyDate birthdate;
    public String gender,province,city;
    private static int count=0;

    public Person(String name, MyDate birthdate, String gender, String province, String city) {
        this.set(name,birthdate,gender,province,city);
       count++;
    }

    public Person(String name,MyDate birthdate)
    {
        this(name,birthdate,"","","");
    }

    public Person(Person per)
    {
        this(per.name, new MyDate(per.birthdate), per.gender,per.province, per.city);
    }

    public Person()
    {
        this("",new MyDate());
    }

    public void set(String name, MyDate birthdate, String gender, String province, String city)
    {
        this.name=name==null?"":name;
        this.birthdate=birthdate;
        this.gender=gender==null?"":gender;
        this.province=province==null? "":province;
        this.city=city==null? "":city;
    }

    public static void howMany(){
        System.out.print(Person.count+"��Person����, ");
    }

    public void set(String name,MyDate birthdate)
    {
        this.set(name,birthdate,"","","");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", birthdate=" + birthdate +
                ", gender='" + gender + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                '}';
    }



    public static void main(String[] args) {
        Person p1=new Person("��С��",new MyDate(1994,3,15));
        Person p2=new Person(p1);   //�������췽��
        Person.howMany();
        System.out.println("p1:"+p1+";\np2:"+p2+"\np1==p2? "+(p1==p2)+"; p1.name==p2.name? " + (p1.name==p2.name)
        +",p1.birthdate==p2.birthdate? "+(p1.birthdate==p2.birthdate));

        p2.name="��"+p2.name.substring(1);
        MyDate date=p2.birthdate;

        date.set(date.getYear()+2,date.getMoth(),date.getDay());

        System.out.println("p1:"+p1+"\np2: "+p2);

    }
}


