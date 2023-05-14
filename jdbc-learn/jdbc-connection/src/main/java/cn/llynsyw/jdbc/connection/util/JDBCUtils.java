package cn.llynsyw.jdbc.connection.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.DataSources;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.Properties;

/**
 * @ClassName JDBCUtils
 * @Description
 * @package jdbc_util
 * @Author luolinyuan
 * @Date 2021/8/18
 **/
public class JDBCUtils {
    /*
     * @Author luolinyuan
     * @Description 使用c3p0数据库连接
     * @Date 2021/8/18
     * @Param []
     * @return java.sql.Connection
     **/


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


    public static <T> T getInstance(Connection conn, Class<T> clazz, String sql, Object... args) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);

            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }

            //执行并获取结果集
            rs = ps.executeQuery();
            //获取元数据
            ResultSetMetaData rsmd = rs.getMetaData();

            //获取列数
            int columnCount = rsmd.getColumnCount();

            if (rs.next()) {

                T t = clazz.newInstance();

                for (int i = 0; i < columnCount; i++) {
                    //获取每个列的列值
                    Object columnValue = rs.getObject(i + 1);
                    //获取字段名而非别名
                    //String columnName = rsmd.getColumnName(i + 1);

                    //获取列的别名
                    String columnLable = rsmd.getColumnLabel(i + 1);

                    //通过反射
                    Field field = clazz.getDeclaredField(columnLable);
                    field.setAccessible(true);
                    field.set(t, columnValue);

                }
                return t;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null)
                    ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return null;
    }

    public static void close() {
        try {
            DataSources.destroy(source);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
