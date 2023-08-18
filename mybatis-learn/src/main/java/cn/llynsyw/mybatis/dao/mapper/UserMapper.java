package cn.llynsyw.mybatis.dao.mapper;

import cn.llynsyw.mybatis.domain.User;

import java.util.List;

public interface UserMapper {
    List<User> findAll();

    User findUserById(int id);

    List<User> findByConditions(User user);

    public List<User> findByIds(List<Integer> usersIds);

    public void dateType(User user);
    int insertUser(User user);

    public User getBirthday(User user);

}
