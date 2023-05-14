package cn.spring.test.service;

import cn.spring.test.pojo.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    void addUser(User user, Long[] roleIds);

    void delUser(Long userId);


    User login(String username, String password);
}
