package cn.llynsyw.spring.aop.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestJdkProxy {
    public static void main(String[] args) {
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if(args[0].equals("guo")) {
                    System.out.println("go fuck yourself  " + args[0]);
                } else {
                    System.out.println("hi good morning !!" +args[0]);
                }
                return null;
            }
        };
        Hello hello = new HelloImpl();

        Hello proxy = (Hello) Proxy.newProxyInstance(Hello.class.getClassLoader(),
                hello.getClass().getInterfaces(),
                handler);

        proxy.morning("guo");
    }
}
