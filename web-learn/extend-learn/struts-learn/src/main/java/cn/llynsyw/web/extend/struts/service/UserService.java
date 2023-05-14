package cn.llynsyw.web.extend.struts.service;


import cn.llynsyw.web.extend.struts.beans.User;

public interface UserService {
    User checkUser(User user);
    User getUserById(int id);
    boolean insertUser(User user);
}
