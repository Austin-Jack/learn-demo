package cn.llynsyw.jdbc.connection.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;


/**
 * @ClassName DruidTest
 * @Description
 * @package jdbc_druid
 * @Author luolinyuan
 * @Date 2021/8/18
 **/
public class DruidTest {
    @Test
    public void tetGetConnection() throws Exception {
        Properties pros = new Properties();

        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("druid.properties");
        pros.load(is);

        DataSource source = DruidDataSourceFactory.createDataSource(pros);
        Connection conn = source.getConnection();
        is.close();

        System.out.println(conn);
    }
}

