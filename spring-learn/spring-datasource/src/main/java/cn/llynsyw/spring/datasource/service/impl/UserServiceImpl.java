package cn.llynsyw.spring.datasource.service.impl;

import cn.llynsyw.spring.datasource.service.UserService;
import cn.llynsyw.spring.datasource.dao.UserDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.beans.PropertyVetoException;
import java.sql.SQLException;

@Service("userService")
public class UserServiceImpl implements UserService {
    /*@Autowired
    @Qualifier("userDao")*/
    //@Autowired
    @Resource(name = "userDao")
    private UserDao userDao;

    @Override
    public void save() throws PropertyVetoException, SQLException {
        userDao.save();
    }
}
