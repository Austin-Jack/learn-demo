package cn.llynsyw.jdbc.basic.demo02;

import cn.llynsyw.jdbc.basic.bean.Customer;
import cn.llynsyw.jdbc.basic.util.JDBCUtils;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.*;

/**
 * @ClassName CustomerForQuery
 * @Description customer表的查询类
 * @package jdbc_demo02
 * @Author luolinyuan
 * @Date 2021/8/15
 **/
public class CustomerForQuery {
    @Test
    public void testQuery1() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            //1.获取数据库的连接
            conn = JDBCUtils.getConnection();

            //2.获取PreparedStatement的实例 (或：预编译sql语句)
            String sql = "select id,name,email,birth from customers where id=?";
            ps = conn.prepareStatement(sql);
            ps.setObject(1, 19);

            //执行并返回结果集
            resultSet = ps.executeQuery();

            //处理结果集
            if (resultSet.next()) {
                //获取当前这条数据的各个字段
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String email = resultSet.getString(3);
                Date birth = resultSet.getDate(4);

                Customer customer = new Customer(id, name, email, birth);
                System.out.println(customer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //5.关闭资源
            JDBCUtils.closeResource(conn, ps, resultSet);
        }
    }

    /**
     * @return void
     * @Author luolinyuan
     * @Description customer 通用查询
     * @Date 2021/8/15
     * @Param [java.lang.String, java.lang.Object...]
     **/
    public Customer queryForCustomers(String sql, Object... args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet res = null;
        try {
            //获取连接
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);

            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }

            res = ps.executeQuery();
            //获取结果集的元数据ResultSetMetaData 可以获取结果集列数
            ResultSetMetaData rsmd = res.getMetaData();

            //通过ResultSetMetaData获取结果集中的列数
            int columnCount = rsmd.getColumnCount();
            //结果集有记录
            if (res.next()) {
                //使用空参构造customer对象
                Customer customer = new Customer();

                for (int i = 0; i < columnCount; i++) {
                    //未知具体字段
                    Object value = res.getObject(i + 1);

                    //获取每个列的列名
                    String columnName = rsmd.getColumnName(i + 1);

                    //为customer对象指定具体的某个属性，赋值为value
                    //利用反射
                    Field field = Customer.class.getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(customer, value);
                }
                return customer;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, ps, res);
        }
        return null;
    }

    @Test
    public void testQueryForCustomers(){
        String sql="select id,name,birth,email from customers where id=?";
        Customer customer=queryForCustomers(sql,13);
        System.out.println(customer);

        sql="select name,email from customers where name=?";
        Customer customer1=queryForCustomers(sql,"罗林园");
        System.out.println(customer1);
    }
}
