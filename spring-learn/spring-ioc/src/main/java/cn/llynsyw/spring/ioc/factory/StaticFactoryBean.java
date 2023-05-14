package cn.llynsyw.spring.ioc.factory;

import cn.llynsyw.spring.ioc.dao.UserDao;
import cn.llynsyw.spring.ioc.dao.impl.UserDaoImpl;

public class StaticFactoryBean {
    public static UserDao createUserDao() {
        return new UserDaoImpl();
    }
}
