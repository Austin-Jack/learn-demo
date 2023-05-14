package cn.llynsyw.java.basic.day02.demo03;

//因为在同一个包里所以不用导包
public class Demo01PhoneOne {
    public static void main(String[] args) {
        Phone one = new Phone();
        System.out.println(one.brand);
        System.out.println(one.color);
        System.out.println(one.price);
        one.call("lly");
    }


}
