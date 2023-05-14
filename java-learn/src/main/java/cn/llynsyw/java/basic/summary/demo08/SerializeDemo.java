package cn.llynsyw.java.basic.summary.demo08;

import java.io.*;

public class SerializeDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Employee e = new Employee();
        e.name = "ZhangSan";
        e.address = "chongqing";
        e.age = 20;
        String file="employeeOut.txt";
        Employee.serialize(e,file);
        Employee e2=Employee.deserialization(file); //反序列化取出给e2

        e2.checkObject();   //检查反序列化情况
    }


}

class Employee implements Serializable {
    public String name;     //姓名
    public String address;  //住址
    public transient int age;//transient瞬态修饰成员不会被序列化

    public void checkObject() {
        System.out.println("Address check:" + name + "-----" + address);
    }

    public static void serialize(Employee e,String fos) throws IOException{
        ObjectOutputStream out = null;
        FileOutputStream fileOut=new FileOutputStream(fos);
        out = new ObjectOutputStream(fileOut);
        out.writeObject(e);
        out.close();    //释放资源
        fileOut.close();
        System.out.println("Serialize   data    is  saved");
    }

    public static Employee deserialization(String fis) throws IOException, ClassNotFoundException {
        Employee e=null;
        FileInputStream fin=new FileInputStream(fis);
        ObjectInputStream in=new ObjectInputStream(fin);    //建立读取对象流
        e=(Employee)in.readObject();    //读取一个对象
        in.close();
        fin.close();
        return e;
    }
}