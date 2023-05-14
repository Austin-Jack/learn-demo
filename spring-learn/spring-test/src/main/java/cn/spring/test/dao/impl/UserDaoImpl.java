package cn.spring.test.dao.impl;

import cn.spring.test.dao.UserDao;
import cn.spring.test.pojo.User;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import java.sql.PreparedStatement;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query("select * from sys_user", new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public Long addUser(User user) {
        /*插入user并返回生成自动的id*/
        //创建preparedStatementCreator
        PreparedStatementCreator creator = connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into sys_user values(?,?,?,?,?)",
                    PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setObject(1, null);
            preparedStatement.setString(2, user.getUsername());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getPhoneNum());
            return preparedStatement;
        };

        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(creator, keyHolder);
        long userId = keyHolder.getKey().longValue();

        /*jdbcTemplate.update("insert  into sys_user values(?,?,?,?,?)",null,user.getUsername(),
                user.getEmail(),user.getPassword(),user.getPhoneNum());*/
        return userId;
    }

    @Override
    public void delUserRoleRelationShip(Long userId) {
        jdbcTemplate.update("delete from sys_user_role where userId = ?", userId);
    }

    @Override
    public void delUser(Long userId) {
        jdbcTemplate.update("delete from sys_user where id = ?", userId);
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) throws EmptyResultDataAccessException {
        User user =jdbcTemplate.queryForObject("select * from sys_user where username = ? and password = ?",
                new BeanPropertyRowMapper<>(User.class),username, password);
        return user;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
