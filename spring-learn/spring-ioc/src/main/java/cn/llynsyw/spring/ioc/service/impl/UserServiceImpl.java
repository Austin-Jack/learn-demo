package cn.llynsyw.spring.ioc.service.impl;

import cn.llynsyw.spring.ioc.dao.UserDao;
import cn.llynsyw.spring.ioc.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public void saveUser() {
        userDao.saveUser();
    }

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserServiceImpl() {

    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
