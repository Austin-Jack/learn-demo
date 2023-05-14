package cn.llynsyw.web.curriculum.exp_7.service;


import cn.llynsyw.web.curriculum.exp_7.beans.User;

public interface UserService {
    User checkUser(User user);
    User getUserById(int id);
    boolean insertUser(User user);
}
