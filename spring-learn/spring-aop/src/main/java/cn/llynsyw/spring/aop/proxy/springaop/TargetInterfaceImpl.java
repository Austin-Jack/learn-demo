package cn.llynsyw.spring.aop.proxy.springaop;

import org.springframework.stereotype.Component;

@Component("target")
public class TargetInterfaceImpl implements TargetInterface {

    @Override
    public void method() {

        System.out.println("Target is running");
        int a = 1 / 0;
    }
}
