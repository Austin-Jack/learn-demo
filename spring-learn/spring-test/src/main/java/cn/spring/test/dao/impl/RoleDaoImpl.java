package cn.spring.test.dao.impl;

import cn.spring.test.dao.RoleDao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import cn.spring.test.pojo.Role;

import java.util.List;

public class RoleDaoImpl implements RoleDao {


    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Role> findAll() {
        return jdbcTemplate.query("select * from sys_role", new BeanPropertyRowMapper<>(Role.class));
    }

    @Override
    public int roleAdd(Role role) {
        return jdbcTemplate.update("insert into sys_role values (?,?,?)", null, role.getRoleName(), role.getRoleDesc());
    }

    @Override
    public List<Role> getByUserId(Long id) {
        return jdbcTemplate.query("select * from sys_user_role ur,sys_role r " +
                "where ur.roleId = r.id and ur.userId = ?", new BeanPropertyRowMapper<Role>(Role.class), id);
    }

    @Override
    public void addUser(Long addUserId, Long[] roleIds) {
        for (Long roleId : roleIds) {
            jdbcTemplate.update("insert into sys_user_role  values (?,?)",addUserId,roleId);
        }
    }


    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
