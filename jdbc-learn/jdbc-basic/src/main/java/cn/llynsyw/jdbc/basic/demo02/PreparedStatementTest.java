package cn.llynsyw.jdbc.basic.demo02;

import cn.llynsyw.jdbc.basic.bean.User;
import cn.llynsyw.jdbc.basic.util.JDBCUtils;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Scanner;

/**
 * @ClassName PreparedStatementTest
 * @Description 使用PreparedStatement解决SQL注入问题
 * @package jdbc_demo02
 * @Author luolinyuan
 * @Date 2021/8/15
 *
 * 除了解决Statement的拼串.sql问题之外，PreparedStatement还有
 * 1.PreparedStatement可以操作Blob的数据，而Statement不行
 * 2.PreparedStatement可以实现更高效的批量操作
 **/
public class PreparedStatementTest {

    @Test
    public void testLogin() {
        Scanner scan = new Scanner(System.in);

        System.out.print("用户名：");
        String userName = scan.nextLine();
        System.out.print("密   码：");
        String password = scan.nextLine();

        // SELECT user,password FROM user_table WHERE USER = '1' or ' AND PASSWORD = '='1' or '1' = '1';
        String sql = "SELECT user,password FROM user_table WHERE user = ? AND PASSWORD = ?";
        User user = getInstance(User.class,sql,userName,password);
        if (user != null) {
            System.out.println("登陆成功!");
        } else {
            System.out.println("用户名或密码错误！");
        }
    }


    public <T> T getInstance(Class<T> clazz, String sql, Object... args) {

        Connection conn = null;
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
            JDBCUtils.closeResource(conn, ps, rs);
        }

        return null;
    }
}
