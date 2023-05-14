package cn.llynsyw.jdbc.connection.c3p0;

import cn.llynsyw.jdbc.connection.bean.Customer;
import cn.llynsyw.jdbc.connection.util.JDBCUtils;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.DataSources;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @ClassName C3P0Test
 * @Description
 * @package jdbc_c3p0
 * @Author luolinyuan
 * @Date 2021/8/17
 **/
public class C3P0Test {

    //方式一 直接填写信息
    @Test
    public void testGetConnection() throws Exception {
        //获取c3p0数据库连接池
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        cpds.setDriverClass("com.mysql.cj.jdbc.Driver"); //loads the jdbc driver
        cpds.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        cpds.setUser("root");
        cpds.setPassword("qwe123");

        /* 通过设置相关参数 对数据库连接池进行管理*/
        //初始时数据库连接池中的连接数
        cpds.setInitialPoolSize(10);

        Connection connection = cpds.getConnection();
        System.out.println(connection);

        //关闭连接池
        DataSources.destroy(cpds);
    }

    //通过配置文件
    @Test
    public void testGetConnection2() throws SQLException {
        ComboPooledDataSource cpds = new ComboPooledDataSource("helloc3p0");
        Connection connection = cpds.getConnection();
        System.out.println(connection);
        DataSources.destroy(cpds);
    }

    @Test
    public void testGetCustomerByID() throws Exception {
//TODO: Test goes here...
        Connection connection = JDBCUtils.getConnection();
        String sql="select name,email,birth from customers where id =?";
        Customer customer =JDBCUtils.getInstance(connection,Customer.class,sql,13);

        System.out.println(customer);

        JDBCUtils.close();
    }
}
