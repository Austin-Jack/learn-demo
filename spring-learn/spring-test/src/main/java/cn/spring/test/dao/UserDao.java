package cn.spring.test.dao;

import cn.spring.test.pojo.User;

import java.util.List;

public interface UserDao {
    public List<User> findAll();

    Long addUser(User user);

    void delUserRoleRelationShip(Long userId);

    void delUser(Long userId);

    User findByUsernameAndPassword(String username, String password);
}
