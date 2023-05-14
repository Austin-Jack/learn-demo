package cn.llynsyw.spring.aop.proxy.cglibproxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibTest {
    public static void main(String[] args) {
        Hello hello = new Hello(); //目标对象
        Enhancer enhancer = new Enhancer(); //增强器
        enhancer.setSuperclass(Hello.class); //设置父类
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                if (objects[0].toString().equals("guo")){
                    System.out.println("go fuck yourself bitch");
                    return null;
                }
                    System.out.println("前置代码增强");
                Object invoke = method.invoke(hello, objects);
                System.out.println("后置代码增强");
                return invoke;
            }
        });

        Hello proxy = (Hello) enhancer.create();

        proxy.morning("guo");
    }
}
