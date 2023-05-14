package cn.llynsyw.spring.aop.proxy.jdkproxy;

public class HelloImpl implements Hello{

    @Override
    public void morning(String name) {
        System.out.println("Good morning" + name);
    }
}
