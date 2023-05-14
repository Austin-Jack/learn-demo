package cn.llynsyw.web.extend.struts.dao;

import cn.llynsyw.web.extend.struts.beans.User;

public interface UserDao {
    User checkUser(User user);

    User getUserById(int id);

    boolean insertUser(User user);
}
