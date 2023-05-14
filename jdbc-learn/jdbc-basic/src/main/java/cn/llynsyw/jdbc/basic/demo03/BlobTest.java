package cn.llynsyw.jdbc.basic.demo03;

import cn.llynsyw.jdbc.basic.bean.Customer;
import cn.llynsyw.jdbc.basic.util.JDBCUtils;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.*;

/**
 * @ClassName BlobTest
 * @Description
 * @package jdbc_demo03
 * @Author luolinyuan
 * @Date 2021/8/16
 **/
public class BlobTest {
    //向数据表customers中插入Blob类型的字段

    @Test
    public void testInsert() {
        FileInputStream is = null;
        Connection conn = null;
        String sql = "insert into customers(name,email,birth,photo) values(?,?,?,?)";
        PreparedStatement ps = null;
        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setObject(1, "Anni");
            ps.setObject(2, "Anni@qq.com");
            ps.setObject(3, "1995-12-12");
            is = new FileInputStream(new File("test.jpg"));
            ps.setBlob(4, is);

            ps.execute();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, ps);
            try {
                if (is != null)
                    is.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    //查询customers中Blob类型
    @Test
    public void testQuery() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        InputStream is = null;
        FileOutputStream fos = null;


        try {
            conn = JDBCUtils.getConnection();
            String sql = "select id,name,email,birth,photo from customers where id=?";
            ps = conn.prepareStatement(sql);

            ps.setInt(1, 21);

            rs = ps.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                Date birth = rs.getDate("birth");


                Customer customer = new Customer(id, name, email, birth);
                System.out.println(customer);

                Blob photo = rs.getBlob("photo");
                is = photo.getBinaryStream();
                fos = new FileOutputStream(name + ".jpg");
                byte[] buffer = new byte[1024];
                int len;
                while ((len = is.read(buffer)) != -1) {
                    fos.write(buffer, 0, len);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, ps, rs);
            try {
                if (is != null)
                    is.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                if (fos != null)
                    fos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
