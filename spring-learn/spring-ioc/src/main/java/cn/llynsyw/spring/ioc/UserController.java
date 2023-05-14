package cn.llynsyw.spring.ioc;

import cn.llynsyw.spring.ioc.pojo.User;
import cn.llynsyw.spring.ioc.dao.impl.UserDaoImpl;
import cn.llynsyw.spring.ioc.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserController {
    @Test
    public void saveUser() {
        ApplicationContext app =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) app.getBean("userService3");
        userService.saveUser();
    }

    @Test
    public void testDataInto() {
        ApplicationContext app =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = (User) app.getBean("lly");
        System.out.println(user);

    }

    @Test
    public void testPropInto() {
        ApplicationContext app =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        //可以传入模板 依据类型返回对象 但是如果存在多个该类型对象则会报错
        //UserDaoImpl userDao = (UserDaoImpl) app.getBean(UserDaoImpl.class);
        UserDaoImpl userDao = (UserDaoImpl) app.getBean("userDaoWithProp");
        userDao.printProperties();
    }
}
