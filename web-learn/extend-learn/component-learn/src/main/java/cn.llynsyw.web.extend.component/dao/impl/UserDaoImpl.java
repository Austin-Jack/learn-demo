package cn.llynsyw.web.extend.component.dao.impl;

import cn.llynsyw.web.extend.component.dao.UserDao;
import cn.llynsyw.web.extend.component.entity.User;

import java.sql.*;
import java.util.UUID;

/*
 *跟数据库发生交互
 *
 */
public class UserDaoImpl implements UserDao {

    @Override
    public User checkUser(User user) {
        if (user.getName()==null||user.getName()==null){
            return null;
        }
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        User u = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/learnweb", "root", "qwe123");
            ps = connection.prepareStatement("select * from user where name =? and pwd =?");
            ps.setString(1, user.getName());
            ps.setString(2, user.getPassword());

            resultSet = ps.executeQuery();

            while (resultSet.next()) {
                u = new User(resultSet.getInt("id"),resultSet.getString("name"), resultSet.getString("pwd"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return u;
    }

    @Override
    public User getById(int id) {
        User u=null;
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/learnweb", "root", "qwe123");
            ps = connection.prepareStatement("select * from user where id= ?");
            ps.setInt(1, id);

            resultSet = ps.executeQuery();

            while (resultSet.next()) {
                u = new User(resultSet.getInt("id"),resultSet.getString("name"), resultSet.getString("pwd"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return  u;
    }


}


