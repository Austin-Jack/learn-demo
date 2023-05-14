package cn.llynsyw.web.extend.struts.service.impl;

import cn.llynsyw.web.extend.struts.beans.User;
import cn.llynsyw.web.extend.struts.dao.UserDao;
import cn.llynsyw.web.extend.struts.dao.impl.UserDaoImpl;
import cn.llynsyw.web.extend.struts.service.UserService;

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
