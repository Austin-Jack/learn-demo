package cn.llynsyw.jdbc.forward.demo;

import cn.llynsyw.jdbc.forward.utils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;

/**
 * @ClassName ConnectionTest
 * @Description
 * @package jdbc_demo01
 * @Author luolinyuan
 * @Date 2021/8/17
 **/
public class ConnectionTest {
    @Test
    public void testGetConnection() throws Exception{
        Connection conn= JDBCUtils.getConnection();
        System.out.println(conn);
        JDBCUtils.closeResource(conn,null);
    }
}
