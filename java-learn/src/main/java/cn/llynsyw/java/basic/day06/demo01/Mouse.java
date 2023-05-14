package cn.llynsyw.java.basic.day06.demo01;

public class Mouse implements USB{
    @Override
    public void open() {
        System.out.println("打开鼠标");
    }

    @Override
    public void close() {
        System.out.println("关闭鼠标");
    }

    public  void useMouse(){
        System.out.println("使用鼠标");
    }
}
