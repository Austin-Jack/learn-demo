package cn.llynsyw.jdbc.forward.demo;

import cn.llynsyw.jdbc.forward.utils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @ClassName TranscationTest
 * @Description
 * @package jdbc_demo01
 * @Author luolinyuan
 * @Date 2021/8/17
 **/
public class TransactionTest {
    /*
      针对于数据表user_table 进行AA向BB转账100操作
     */
    @Test
    public void testUpdate() {
        String sql = "update user_table set balance = balance -100 where user = ?";
        update(sql, "AA");

        //模拟异常
        System.out.println(10 / 0);

        sql = "update user_table set balance = balance +100 where user = ?";
        update(sql, "BB");

    }

    /*
     * @Author luolinyuan
     * @Description 实现对数据的增加，修改，删除
     * @Date 2021/8/16
     * @Param [java.lang.String, java.lang.Object...]
     * @return int
     **/
    public static int update(String sql, Object... args) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            //1.获取数据库的连接
            conn = JDBCUtils.getConnection();

            //2.获取PreparedStatement的实例 (或：预编译sql语句)
            ps = conn.prepareStatement(sql);
            //3.填充占位符
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
            //5.关闭资源
            JDBCUtils.closeResource(conn, ps);

        }
        return 0;
    }

    //涉及事务 所以使用同一个连接，避免连接关闭时自动提交事务
    @Test
    public void testUpdateWithTransaction() throws Exception {

        Connection connection = null;
        try {
            connection = JDBCUtils.getConnection();
            connection.setAutoCommit(false); //取消自动提交事务
            String sql = "update user_table set balance = balance -100 where user = ?";
            update(connection,sql, "AA");

            //模拟异常
            System.out.println(10 / 0);

            sql = "update user_table set balance = balance +100 where user = ?";
            update(connection,sql, "BB");

            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
            connection.rollback(); //出现错误回滚  默认会回滚
        } finally {
            JDBCUtils.closeResource(connection, null);
            connection.setAutoCommit(true); //设置为默认提交 以便下次使用
        }

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
            JDBCUtils.closeResource(null, ps);
        }
        return 0;
    }
}
