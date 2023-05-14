package cn.llynsyw.mybatis.dao;

import cn.llynsyw.mybatis.domain.User;

import java.io.IOException;
import java.util.List;

public interface UserDao {
    public List<User> findAll() throws IOException;
}
