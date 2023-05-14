package cn.llynsyw.spring.ioc.dao.impl;

import cn.llynsyw.spring.ioc.dao.UserDao;

import java.util.Properties;

public class UserDaoImpl implements UserDao {

    private Properties properties;
    @Override
    public void saveUser() {
        System.out.println("saveUSer() is running ...");
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }
    public void init() {
        System.out.println("init()方法被调用..");
    }

    public void destroy() {
        System.out.println("destroy() 方法被调用");
    }

    public void printProperties() {
        System.out.println(properties);
    }
}
