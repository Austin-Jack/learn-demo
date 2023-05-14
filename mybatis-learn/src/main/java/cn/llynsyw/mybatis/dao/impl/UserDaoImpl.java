package cn.llynsyw.mybatis.dao.impl;

import cn.llynsyw.mybatis.dao.UserDao;
import cn.llynsyw.mybatis.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public List<User> findAll() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSession session = new SqlSessionFactoryBuilder().build(resourceAsStream).openSession();
        List<User> userList = session.selectList("userMapper.findAll");
        return userList;
    }
}
