package cn.llynsyw.spring.aop.proxy.springaop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component("myAspect")
@Aspect()
public class MyAspect {
    @AfterThrowing("cn.llynsyw.spring.aop.proxy.springaop.MyAspect.myPoint()")
    public void before() {
        //    前置增强方法
        System.out.println("发生了异常");
    }

    @Around("cn.llynsyw.spring.aop.proxy.springaop.MyAspect.myPoint()")
    public void around(ProceedingJoinPoint pj) throws Throwable {
        System.out.println("执行前");
        pj.proceed();
        System.out.println("执行后");
    }

    @Pointcut("execution(* com.lly.proxy.springaop.*.*(..))")
    public void myPoint() {
    }

    ;
}
