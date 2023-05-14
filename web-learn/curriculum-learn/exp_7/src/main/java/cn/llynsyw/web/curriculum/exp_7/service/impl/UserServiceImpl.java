package cn.llynsyw.web.curriculum.exp_7.service.impl;

import cn.llynsyw.web.curriculum.exp_7.beans.User;
import cn.llynsyw.web.curriculum.exp_7.dao.UserDao;
import cn.llynsyw.web.curriculum.exp_7.dao.impl.UserDaoImpl;
import cn.llynsyw.web.curriculum.exp_7.service.UserService;

public class UserServiceImpl implements UserService {
    UserDao userDao=new UserDaoImpl();
    @Override
    public User checkUser(User user) {
        return userDao.checkUser(user);
    }

    @Override
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    @Override
    public boolean insertUser(User user) {
        return userDao.insertUser(user);
    }
}
