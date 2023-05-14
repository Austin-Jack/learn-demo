package cn.llynsyw.spring.datasource.dao;

import java.beans.PropertyVetoException;
import java.sql.SQLException;

public interface UserDao {

    public void save() throws PropertyVetoException, SQLException;
}
