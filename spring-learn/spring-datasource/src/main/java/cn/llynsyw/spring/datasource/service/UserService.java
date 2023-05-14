package cn.llynsyw.spring.datasource.service;

import java.beans.PropertyVetoException;
import java.sql.SQLException;

public interface UserService {
    public void save() throws PropertyVetoException, SQLException;
}
