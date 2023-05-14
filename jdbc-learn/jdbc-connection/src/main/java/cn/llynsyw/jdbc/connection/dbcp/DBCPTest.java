package cn.llynsyw.jdbc.connection.dbcp;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @ClassName DBCPTest
 * @Description
 * @package jdbc_dbcp
 * @Author luolinyuan
 * @Date 2021/8/18
 **/
public class DBCPTest {
    @Test
    public void testGetConnection() throws SQLException {
        //创建DBCP连接池
        BasicDataSource source=new BasicDataSource();

        //设置信息
        source.setDriverClassName("com.mysql.cj.jdbc.Driver");
        source.setUrl("jdbc:mysql://localhost:3306/test");
        source.setUsername("root");
        source.setPassword("qwe123");

        //设置其他涉及数据库连接池的管理
        source.setInitialSize(10);
        source.setMaxActive(10);

        Connection conn=source.getConnection();

        System.out.println(conn);
    }

    @Test
    public void testGetConnection2() throws Exception {
        Properties pros=new Properties();

        //方式一
        // ClassLoader.getSystemClassLoader().getResourceAsStream("dbcp.properties");
        //方式二
        FileInputStream is=new FileInputStream(new File(("src/dbcp.properties")));
        pros.load(is);
        DataSource source = BasicDataSourceFactory.createDataSource(pros);

        Connection conn=source.getConnection();
        System.out.println(conn);
    }

}
