package cn.spring.test.service.impl;

import cn.spring.test.dao.RoleDao;
import cn.spring.test.dao.UserDao;
import cn.spring.test.pojo.Role;
import cn.spring.test.pojo.User;
import cn.spring.test.service.UserService;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    private RoleDao roleDao;

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> findAll() {
        List<User> userList = userDao.findAll();
        /*封装角色*/
        for (User user : userList) {
            Long id = user.getId();
            List<Role> roles = roleDao.getByUserId(id);
            user.setRoleList(roles);
        }
        return userList;
    }

    @Override
    public void addUser(User user, Long[] roleIds) {
        //向user表存数据
        roleDao.addUser(userDao.addUser(user),roleIds);
        //user-role表中存数据

    }

    @Override
    public void delUser(Long userId) {
        /*删除关系表*/
        userDao.delUserRoleRelationShip(userId);
        /*删除User表*/
        userDao.delUser(userId);
    }

    @Override
    public User login(String username, String password) {
        try {
            return userDao.findByUsernameAndPassword(username,password);
        }catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}
