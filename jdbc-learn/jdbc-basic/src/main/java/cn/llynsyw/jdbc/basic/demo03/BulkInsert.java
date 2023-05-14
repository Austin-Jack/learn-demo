package cn.llynsyw.jdbc.basic.demo03;

import cn.llynsyw.jdbc.basic.util.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @ClassName BulkInsert
 * @Description
 * @package jdbc_demo03
 * @Author luolinyuan
 * @Date 2021/8/17
 **/
public class BulkInsert {
    @Test
    public void testInsert1() {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "insert into goods(name) values(?)";
        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);

            for (int i = 0; i < 20000; i++) {
                ps.setObject(1, "name_" + i);

                ps.execute();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null)
                    conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                if (ps != null)
                    ps.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }


    //攒SQL执行
    @Test
    public void testInset2() {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "insert into goods(name) values(?)";

        try {
            conn = JDBCUtils.getConnection();
            //设置不自动提交事务
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);

            for (int i = 0; i < 100000; i++) {
                ps.setObject(1, "name_" + i);

                //1.攒sql
                ps.addBatch();

                if (i % 500 == 0){
                    //2.执行batch
                    ps.executeBatch();

                    //3.清空batch
                    ps.clearBatch();
                }
            }
            //提交事务
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,ps);
            try {
                if (conn != null)
                    conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                if (ps != null)
                    ps.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
