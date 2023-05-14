package cn.llynsyw.web.extend.component.dao;

import cn.llynsyw.web.extend.component.entity.User;

public interface UserDao {
    public User checkUser(User user);

    public User getById(int id);
}
