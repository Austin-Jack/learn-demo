package cn.llynsyw.spring.datasource.dao.impl;

import com.alibaba.druid.pool.DruidDataSource;
import cn.llynsyw.spring.datasource.dao.UserDao;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

    @Value("${jdbc.driver}")
    private String driverClassName;

    @Value("${jdbc.username}")
    private String name;

    @Value("${jdbc.password}")
    private String password;

    @Value("${jdbc.url}")
    private String url;

    @Autowired
    private DataSource dataSource;
    @Test
    public void testC3p0() throws PropertyVetoException, SQLException {
        //创建数据源
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        //设置数据库连接参数
        dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setUser("root");
        dataSource.setPassword("qwe123");
        //获得连接对象
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }

    @Test
    public void testDruid() throws Exception {
        //创建数据源
        DruidDataSource dataSource = new DruidDataSource();
        //设置数据库连接参数
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setUsername("root");
        dataSource.setPassword("qwe123");
        //获得连接对象
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }

    @Test
    public void testC3P0ByProperties() throws Exception {
        //加载类路径下的jdbc.properties
        ResourceBundle rb = ResourceBundle.getBundle("jdbc");//只需要前缀名称
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(rb.getString("jdbc.driver"));
        dataSource.setJdbcUrl(rb.getString("jdbc.url"));
        dataSource.setUser(rb.getString("jdbc.username"));
        dataSource.setPassword(rb.getString("jdbc.password"));
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }

    @Test
    public void testSpringDataSource() throws SQLException {
        ApplicationContext app =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        DataSource dataSource = (DataSource) app.getBean("druid");
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }

    @Override
    public void save() throws PropertyVetoException, SQLException {
        System.out.println("save() is running");
        /*
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setPassword(password);
        dataSource.setJdbcUrl(url);
        dataSource.setUser(name);
        dataSource.setDriverClass(driverClassName);
        Connection connection = dataSource.getConnection();
        System.out.println(connection);*/
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }
}
