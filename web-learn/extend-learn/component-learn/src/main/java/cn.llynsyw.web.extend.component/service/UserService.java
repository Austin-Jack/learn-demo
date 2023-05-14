package cn.llynsyw.web.extend.component.service;


import cn.llynsyw.web.extend.component.entity.User;

public interface UserService {
    public User checkUser(User user);

    public User getById(int id);
}
