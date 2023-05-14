package cn.spring.test.dao;

import cn.spring.test.pojo.Role;

import java.util.List;

public interface RoleDao {
    public List<Role> findAll();

    int roleAdd(Role role);

    List<Role> getByUserId(Long id);

    void addUser(Long addUser, Long[] roleIds);
}
