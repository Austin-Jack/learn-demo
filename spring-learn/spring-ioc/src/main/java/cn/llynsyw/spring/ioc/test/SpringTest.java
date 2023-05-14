package cn.llynsyw.spring.ioc.test;

import cn.llynsyw.spring.ioc.dao.UserDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {
    @Test
    public void testBean() {
        //获取配置文件
        ApplicationContext app =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        //从IOC容器中获取实例的一种方式
        //UserDao userDao = (UserDao) app.getBean("userDao");
        //userDao.saveUser();
        //scope为prototype每次创建新的对象
        UserDao userDao1 = (UserDao) app.getBean("userDao");
        UserDao userDao2 = (UserDao) app.getBean("userDao");
        System.out.println(userDao1 == userDao2);
        //scope为默认singleton 手动关闭才有输出
        ((ClassPathXmlApplicationContext)app).close();
    }
    @Test
    public void testCreateBean() {
        ApplicationContext app =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao) app.getBean("userDao");
        userDao.saveUser();
    }
}
