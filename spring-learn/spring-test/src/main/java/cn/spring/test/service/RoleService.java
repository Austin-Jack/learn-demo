package cn.spring.test.service;

import cn.spring.test.pojo.Role;

import java.util.List;

public interface RoleService {
    public List<Role> roleList();

    int addRole(Role role);
}
