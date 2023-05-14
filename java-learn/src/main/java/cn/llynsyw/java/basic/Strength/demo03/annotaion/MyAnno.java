package cn.llynsyw.java.basic.Strength.demo03.annotaion;

import java.lang.annotation.*;

//标识MyAnno注解只能作用于类,方法，成员变量
@Target(value = {ElementType.TYPE,ElementType.METHOD,ElementType.FIELD})
//标识MyAnno注解会保留到class字节码文件中并被JVM读取到
@Retention(value = RetentionPolicy.RUNTIME)
//会被抽取到javadoc文档中
@Documented
//标识该注解会被子类自动继承
@Inherited
public @interface MyAnno {
     String show();
}
