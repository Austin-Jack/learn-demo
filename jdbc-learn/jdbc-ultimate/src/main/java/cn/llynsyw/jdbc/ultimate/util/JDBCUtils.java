package cn.llynsyw.jdbc.ultimate.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.mchange.v2.c3p0.DataSources;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @ClassName JDBCUtils
 * @Description
 * @package jdbc_util
 * @Author luolinyuan
 * @Date 2021/8/18
 **/
public class JDBCUtils {
    private static DataSource source;

    public static Connection getConnection() throws SQLException {
        return source.getConnection();
    }

    /*
     * @Author luolinyuan
     * @Description 使用Druid数据库连接池技术
     * @Date 2021/8/18
     * @Param
     * @return
     **/
    static {
        InputStream is = null;
        try {
            Properties pros = new Properties();

            is = ClassLoader.getSystemClassLoader().getResourceAsStream("druid.properties");
            pros.load(is);

            source = DruidDataSourceFactory.createDataSource(pros);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null)
                    is.close();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
    }

    public static void closeSource() {
        try {
            DataSources.destroy(source);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
