package cn.llynsyw.jdbc.basic.demo02;

import cn.llynsyw.jdbc.basic.util.JDBCUtils;
import org.junit.Test;

import java.io.InputStream;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Properties;

/**
 * @ClassName PreparedStatementUpdateTest
 * @Description 实现对数据表的增删改
 * @package jdbc_demo02
 * @Author luolinyuan
 * @Date 2021/8/14
 **/
public class PreparedStatementUpdateTest {
    //向customer表中添加依一条记录
    @Test
    public void testInsert() {
        Connection conn = null;
        PreparedStatement ps = null;
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
        try {

            Properties pro = new Properties();
            pro.load(is);

            String user = pro.getProperty("user");
            String password = pro.getProperty("password");
            String url = pro.getProperty("url");
            String driverClass = pro.getProperty("driverClass");

            Class.forName(driverClass);

            conn = DriverManager.getConnection(url, user, password);

            String sql = "insert into customers(name,email,birth)values(?,?,?)";// ?是占位符
            //预编译sql语句
            ps = conn.prepareStatement(sql);
            //填充占位符
            ps.setString(1, "罗林园");
            ps.setString(2, "22152429782@qq.com");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = sdf.parse("1999-11-12");
            ps.setDate(3, new Date(date.getTime()));

            //执行操作
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //资源释放
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
    }

    //修改customers表的一条记录
    @Test
    public void testUpdate() throws Exception {
        //1.获取连接
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtils.getConnection();
            //2.预编译sql语句,返回PreparedStatement的实例
            String sql = "update customers set name =? where id =?";
            ps = conn.prepareStatement(sql);
            //3.填充占位符
            ps.setObject(1, "莫扎特");
            ps.setInt(2, 18);

            //4.执行
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //5.资源的关闭
            JDBCUtils.closeResource(conn, ps);
        }

    }

    //通用的增、删、改操作（体现一：增、删、改 ； 体现二：针对于不同的表）
    public void update(String sql,Object ... args){
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            //1.获取数据库的连接
            conn = JDBCUtils.getConnection();

            //2.获取PreparedStatement的实例 (或：预编译sql语句)
            ps = conn.prepareStatement(sql);
            //3.填充占位符
            for(int i = 0;i < args.length;i++){
                ps.setObject(i + 1, args[i]);
            }

            //4.执行sql语句
            ps.execute();
        } catch (Exception e) {

            e.printStackTrace();
        }finally{
            //5.关闭资源
            JDBCUtils.closeResource(conn, ps);

        }
    }

    @Test
    public void testCommonUpdate(){
        //String sql="delete from customers where id=?";
        //update(sql,3);

        //使用 · · 区别关键字
        String sql="update `order` set order_name = ? where order_id =?";
        update(sql,"DD","2");
    }
}
