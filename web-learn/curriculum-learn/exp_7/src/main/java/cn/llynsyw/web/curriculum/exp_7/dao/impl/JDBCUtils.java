package cn.llynsyw.web.curriculum.exp_7.dao.impl;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

class JDBCUtils {
    //获取一个连接
    public static Connection getConnection() throws Exception{
        //连接数据库的用户名和密码
        Properties pro=new Properties();
        InputStream input = JDBCUtils.class.getResourceAsStream("/jdbc.properties");
        pro.load(input);
        String username=pro.getProperty("username");
        String passwd=pro.getProperty("password");
        String url=pro.getProperty("url");
        String driverClass=pro.getProperty("driverClass");
        Class.forName(driverClass);

        Connection connection=DriverManager.getConnection(url,username,passwd);
        return connection;
    }



    /*
        关闭资源 连接 或者PreparedStatement
     */
    public static void closeResource(Connection conn, PreparedStatement ps) {
        try {
            if (ps != null)
                ps.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            if (conn != null)
                conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /*
        关闭资源 当有返回集时
     */
    public static void closeResource(Connection conn, PreparedStatement ps, ResultSet rs) {
        try {
            if (ps != null)
                ps.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            if (conn != null)
                conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            if (rs != null)
                rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}