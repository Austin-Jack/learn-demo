package cn.llynsyw.jdbc.ultimate.qureyrunner;

import cn.llynsyw.jdbc.jdbc_bean.Customer;
import cn.llynsyw.jdbc.ultimate.util.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;
import org.junit.Test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @ClassName QueryRunerTest
 * @Description
 * @package jdbc_queryrunner
 * @Author luolinyuan
 * @Date 2021/8/18
 **/
public class QueryRunnerTest {
    @Test
    public void testInsert() throws SQLException {
        QueryRunner runner = new QueryRunner();

        Connection conn = JDBCUtils.getConnection();
        String sql = "insert into customers(name,email,birth) values(?,?,?) ";
        int insertCount = runner.update(conn, sql, "坤坤", "caixukun@qq.con", "1992-01-21");
        System.out.println(insertCount);

        conn.close();
    }
    
    /*
    * @Author luolinyuan
    * @Description BeanHandler是ResultSetHandler接口的实现类,用于封装表中的一条记录
    * @Date 2021/8/18
    * @Param []
    * @return void
    **/
    //查询测试
    @Test
    public void testQuery1() throws SQLException {
        QueryRunner runner = new QueryRunner();
        Connection conn = JDBCUtils.getConnection();
        BeanHandler<Customer> handler = new BeanHandler<>(Customer.class);

        String sql = "select id,name,email,birth from customers where id= ?";
        Customer customer = runner.query(conn, sql, handler, 13);
        System.out.println(customer);

        JDBCUtils.closeSource();
        conn.close();
    }

    @Test
    public void testQuery2() throws SQLException {
        QueryRunner runner = new QueryRunner();
        Connection conn = JDBCUtils.getConnection();

        BeanListHandler<Customer> handler=new BeanListHandler<>(Customer.class);
        String sql = "select id,name,email,birth from customers where id < ?";
        List<Customer> customer = runner.query(conn, sql, handler, 29);
        System.out.println(customer);

        JDBCUtils.closeSource();
        conn.close();
    }


     @Test
    public void testQuery3() throws SQLException {
        QueryRunner runner = new QueryRunner();
        Connection conn = JDBCUtils.getConnection();

        MapHandler handler=new MapHandler();

        String sql = "select id,name,email,birth from customers where id = ?";
        Map<String, Object> customer = runner.query(conn, sql, handler, 13);
        System.out.println(customer);

        JDBCUtils.closeSource();
        conn.close();
    }

    @Test
    public void testQuery4() throws SQLException {
        QueryRunner runner = new QueryRunner();
        Connection conn = JDBCUtils.getConnection();

        MapListHandler handler=new MapListHandler();

        String sql = "select id,name,email,birth from customers where id < ?";
        List<Map<String, Object>> list = runner.query(conn, sql, handler, 23);

        list.forEach(System.out::println);

        JDBCUtils.closeSource();
        conn.close();
    }


    @Test
    public void testQuery5() throws SQLException {
        QueryRunner runner = new QueryRunner();
        Connection conn = JDBCUtils.getConnection();

        MapListHandler handler=new MapListHandler();

        String sql = "select id,name,email,birth from customers where id < ?";
        List<Map<String, Object>> list = runner.query(conn, sql, handler, 23);

        list.forEach(System.out::println);

        JDBCUtils.closeSource();
        conn.close();
    }

    /*
    * @Author luolinyuan
    * @Description 用于查询特殊值，或类型
    * @Date 2021/8/18
    * @Param []
    * @return void
    **/
    @Test
    public void testQuery6() throws SQLException {
        QueryRunner runner = new QueryRunner();
        Connection conn = JDBCUtils.getConnection();

        ScalarHandler handler=new ScalarHandler();

        String sql = "select max(birth) from customers";

        Date maxBirth= (Date) runner.query(conn, sql, handler);

        System.out.println(maxBirth);

        JDBCUtils.closeSource();
        conn.close();
    }
}
