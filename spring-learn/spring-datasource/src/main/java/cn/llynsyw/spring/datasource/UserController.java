package cn.llynsyw.spring.datasource;

import cn.llynsyw.spring.datasource.config.SpringConfiguration;
import cn.llynsyw.spring.datasource.service.UserService;
import cn.llynsyw.spring.datasource.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.beans.PropertyVetoException;
import java.sql.SQLException;

public class UserController {
    @Test
    public void testAnnotation() throws PropertyVetoException, SQLException {
       ApplicationContext app =
               new AnnotationConfigApplicationContext(SpringConfiguration.class);
        UserService userService = app.getBean(UserServiceImpl.class);
        userService.save();
    }
}
