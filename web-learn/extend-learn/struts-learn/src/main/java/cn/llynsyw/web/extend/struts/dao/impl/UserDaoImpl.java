package cn.llynsyw.web.extend.struts.dao.impl;

import cn.llynsyw.web.extend.struts.beans.User;
import cn.llynsyw.web.extend.struts.dao.UserDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDaoImpl implements UserDao {

    @Override
    public User checkUser(User user) {
        String sql="select id,username,password from tb_user where username = ? and password = ?";
        Connection connection=null;
        PreparedStatement preStatement=null;

        ResultSet resultSet=null;
        try {
            connection=JDBCUtils.getConnection();
            preStatement=connection.prepareStatement(sql);

            preStatement.setString(1,user.getName());
            preStatement.setString(2,user.getPassword());
            resultSet=preStatement.executeQuery();
            //如果存在这个用户

            if (resultSet.next()){
                //将id值加入user中
                user.setId(resultSet.getInt(1));
            }else {
                //不存在则将该user置为null
                user=null;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {  //关闭连接释放资源
            JDBCUtils.closeResource(connection,preStatement,resultSet);
        }

        return user;
    }

    @Override
    public User getUserById(int id) {
        User user=null;
        String sql="select id,username,password from tb_user where id = ?";
        Connection connection=null;
        PreparedStatement preStatement=null;
        ResultSet resultSet=null;
        try {
            connection=JDBCUtils.getConnection();
            preStatement=connection.prepareStatement(sql);
            preStatement.setInt(1,id);
            resultSet=preStatement.executeQuery();
            //如果存在这个用户
            if (resultSet.next()){
                String name = resultSet.getString(2);
                String password = resultSet.getString(3);
                //实例化对象并存入其用户名及其密码
                user=new User(id,name,password);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {  //关闭连接释放资源
            JDBCUtils.closeResource(connection,preStatement,resultSet);
        }
        return user;
    }

    public boolean insertUser(User user){
        String sql="select username from tb_user where username = ?";

        Connection connection=null;
        PreparedStatement preStatement=null;
        ResultSet resultSet=null;
        try {
            connection=JDBCUtils.getConnection();
            preStatement=connection.prepareStatement(sql);
            preStatement.setString(1,user.getName());
            //如果存在该用户名
            if ((resultSet=preStatement.executeQuery()).next()) {
                return false;
            }
            String insertSQL="insert into tb_user(username,password) values(?,?)";
            preStatement=connection.prepareStatement(insertSQL);
            preStatement.setString(1,user.getName());
            preStatement.setString(2,user.getPassword());
            preStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {  //关闭连接释放资源
            JDBCUtils.closeResource(connection,preStatement,resultSet);
        }

        return true;
    }


}
