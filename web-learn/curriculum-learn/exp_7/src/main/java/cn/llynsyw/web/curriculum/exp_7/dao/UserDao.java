package cn.llynsyw.web.curriculum.exp_7.dao;

import cn.llynsyw.web.curriculum.exp_7.beans.User;

public interface UserDao {
    User checkUser(User user);

    User getUserById(int id);

    boolean insertUser(User user);
}
