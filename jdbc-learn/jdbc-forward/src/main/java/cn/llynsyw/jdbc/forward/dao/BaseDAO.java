package cn.llynsyw.jdbc.forward.dao;


import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @ClassName BaseDAO
 * @Description
 * @package jdbc_dao
 * @Author luolinyuan
 * @Date 2021/8/17
 **/
public class BaseDAO<T> {

    private Class<T> clazz=null;

    {
        //非静态方法 给clazz赋值
        //获取当前BaseDAO子类继承的父类中的泛型
        Type genericSuperclass = this.getClass().getGenericSuperclass();
        ParameterizedType paramType=(ParameterizedType) genericSuperclass;

        Type[] typeArguments = paramType.getActualTypeArguments();
        clazz= (Class<T>) typeArguments[0];
    }

    public  <T> T getValue(Connection conn,String sql,Object...args){
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            ps=conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1,args[i]);

            }

            rs=ps.executeQuery();
            if (rs.next()) {
                return (T) rs.getObject(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            closeResource(ps,rs);
        }
        return null;
    }

    public static int update(Connection conn, String sql, Object... args) {
        PreparedStatement ps = null;
        try {
            //1.获取PreparedStatement的实例 (或：预编译sql语句)
            ps = conn.prepareStatement(sql);
            //2.填充占位符
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }

            //如果执行的是查询操作有返回结果则返回ture
            //如果是增删改操作没有返回结果 返回false
            //ps.execute();

            //返回影响的行数
            return ps.executeUpdate();
        } catch (Exception e) {

            e.printStackTrace();
        } finally {
            closeResource(ps,null);
        }
        return 0;
    }

    public T getInstance(Connection conn, String sql, Object... args) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
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
            closeResource(ps, rs);
        }

        return null;
    }

    public static void closeResource(PreparedStatement ps, ResultSet rs) {
        try {
            if (ps != null)
                ps.close();
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


    public List<T> getForList(Connection conn, String sql, Object... args) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
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

            //创建集合对象
            ArrayList<T> list = new ArrayList<>();

            while (rs.next()) {

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
                list.add(t);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResource(ps, rs);
        }
        return null;
    }

    public static Connection getConnection() throws Exception {
        InputStream in = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");

        Properties pro = new Properties();
        pro.load(in);
        String user = pro.getProperty("user");
        String password = pro.getProperty("password");
        String url = pro.getProperty("url");
        String driverClass = pro.getProperty("driverClass");

        Class.forName(driverClass);

        Connection conn = DriverManager.getConnection(url, user, password);
        return conn;
    }

    /*
     * @Author luolinyuan
     * @Description 关闭资源
     * @Date 2021/8/14
     * @Param [java.sql.Connection, java.sql.PreparedStatement]
     * @return void
     **/
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

    public static void closeConnection(Connection connection){
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
