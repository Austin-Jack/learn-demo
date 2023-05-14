package cn.llynsyw.spring.datasource.config;

import org.springframework.context.annotation.*;

//标志该类是Spring核心配置类
@Configuration
@ComponentScan("com.lly") //注解扫描
@Import(DataSourceConfiguration.class)
public class SpringConfiguration {




}
