package cn.llynsyw.spring.mvc.dao.impl;

import cn.llynsyw.spring.mvc.dao.UserDao;

public class UserDaoImpl implements UserDao {
    @Override
    public void save() {
        System.out.println("save running...");
    }
}
