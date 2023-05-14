package cn.llynsyw.jdbc.basic.demo01;


import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @ClassName ConnectionTest
 * @Description
 * @package jdbc_demo01
 * @Author luolinyuan
 * @Date 2021/8/13
 **/
public class ConnectionTest {
    //JDBC连接方式一
    @Test
    public void testConnection01() throws SQLException {
        //获取Driver实现类对象
        Driver driver = new com.mysql.cj.jdbc.Driver();

        //jdbc:mysql:协议
        //localhost:ip  地址
        //3306 默认端口
        //test 数据库名称
        String url = "jdbc:mysql://localhost:3306/test";

        //将用户名和密码封装在Properties中
        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "qwe123");

        Connection conn = driver.connect(url,info);
        System.out.println(conn);
    }

    //JDBC连接方式二:方式一的迭代,使用反射加载驱动
    @Test
    public void testConnection2() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        //    获取Driver实现类对象，使用反射
        Class cls = Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver = (Driver) cls.newInstance();

        String url = "jdbc:mysql://localhost:3306/test";

        //将用户名和密码封装在Properties中
        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "qwe123");

        Connection connection = driver.connect(url, info);
        System.out.println(connection);

    }

    //使用DriverManager替换Driver
    @Test
    public void testConnection3() throws Exception {
        Class cls = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) cls.newInstance();

        //    提供三个连接的基本信息
        String url="jdbc:mysql://localhost:3306/test";
        String user="root";
        String password="qwe123";

        //    注册驱动
        DriverManager.registerDriver(driver);
        //获取连接
        Connection conn=DriverManager.getConnection(url,user,password);
        System.out.println(conn);
    }

    //使用mysql实现的加载类
    @Test
    public void testConnection4() throws Exception {
        //    提供三个连接的基本信息
        String url="jdbc:mysql://localhost:3306/test";
        String user="root";
        String password="qwe123";
        //加载Driver 执行静态代码块
        Class.forName("com.mysql.cj.jdbc.Driver");
        //省略加载类  因为mysql实现类中声明了此操作
        //静态代码块在加载类的时候执行
        //获取连接
        Connection conn=DriverManager.getConnection(url,user,password);
        System.out.println(conn);
    }

    //将数据库需要的四个基本信息声明在配置文件中
    //实现了数据与代码分离即解耦
    @Test
    public void testConnection5() throws Exception {
        //Class.forName("com.mysql.jdbc.Driver");
        InputStream in = ConnectionTest.class.getClassLoader().getResourceAsStream("jdbc.properties");

        Properties pro=new Properties();
        pro.load(in);
        String user=pro.getProperty("user");
        String password=pro.getProperty("password");
        String url=pro.getProperty("url");
        String driverClass=pro.getProperty("driverClass");

        Class.forName(driverClass);

        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println(conn);

    }
}
