package cn.llynsyw.spring.mvc.service.impl;

import cn.llynsyw.spring.mvc.dao.UserDao;
import cn.llynsyw.spring.mvc.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    @Override
    public void save() {
        userDao.save();
    }
}
