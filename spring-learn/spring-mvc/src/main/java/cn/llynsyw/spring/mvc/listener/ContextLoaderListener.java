package cn.llynsyw.spring.mvc.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextLoaderListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        //ApplicationContext app =
        //        new ClassPathXmlApplicationContext("applicationContext.xml");

        String contextConfigLocation = servletContext.getInitParameter("contextConfigLocation");
        System.out.println(contextConfigLocation);
        ApplicationContext app =
                new ClassPathXmlApplicationContext(contextConfigLocation);
        //    将Spring的应用上下文的对象存储到最大的域中
        servletContext.setAttribute("app",app);
    }
}
