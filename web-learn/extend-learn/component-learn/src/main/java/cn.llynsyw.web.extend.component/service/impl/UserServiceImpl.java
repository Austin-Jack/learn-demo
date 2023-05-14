package cn.llynsyw.web.extend.component.service.impl;

import cn.llynsyw.web.extend.component.dao.UserDao;
import cn.llynsyw.web.extend.component.dao.impl.UserDaoImpl;
import cn.llynsyw.web.extend.component.entity.User;
import cn.llynsyw.web.extend.component.service.UserService;


public class UserServiceImpl implements UserService {

    UserDao userDao = new UserDaoImpl();

    @Override
    public User checkUser(User user) {
        return userDao.checkUser(user);
    }

    @Override
    public User getById(int id) {
       return userDao.getById(id);
    }
}
