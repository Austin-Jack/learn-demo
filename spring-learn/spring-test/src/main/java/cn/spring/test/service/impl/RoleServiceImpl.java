package cn.spring.test.service.impl;

import cn.spring.test.dao.impl.RoleDaoImpl;
import cn.spring.test.dao.RoleDao;
import cn.spring.test.pojo.Role;
import cn.spring.test.service.RoleService;

import java.util.List;

public class RoleServiceImpl implements RoleService {

    private RoleDao roleDao;

    @Override
    public List<Role> roleList() {
        return roleDao.findAll();
    }

    @Override
    public int addRole(Role role) {
        return roleDao.roleAdd(role);
    }


    public void setRoleDao(RoleDaoImpl roleDao) {
        this.roleDao = roleDao;
    }
}
