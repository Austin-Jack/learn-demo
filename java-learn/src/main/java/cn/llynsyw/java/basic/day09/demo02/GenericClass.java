package cn.llynsyw.java.basic.day09.demo02;

//泛型类
public class GenericClass <E> {
    private E name;

    public E getName() {
        return name;
    }

    public void setName(E name) {
        this.name = name;
    }
}
