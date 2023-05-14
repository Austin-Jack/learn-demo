package cn.llynsyw.jdbc.basic.demo02;




import cn.llynsyw.jdbc.basic.bean.Order;
import cn.llynsyw.jdbc.basic.util.JDBCUtils;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.*;

/**
 * @ClassName OrderForQuery
 * @Description order表的通用查询类
 * @package jdbc_demo02
 * @Author luolinyuan
 * @Date 2021/8/15
 **/
public class OrderForQuery {
    @Test
    public void testQuery1() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtils.getConnection();
            String sql = "select order_id,order_name,order_date from `order` where order_id=?";
            ps = conn.prepareStatement(sql);
            ps.setObject(1, 1);

            rs = ps.executeQuery();
            if (rs.next()) {
                int id = (int) rs.getObject(1);
                String name = (String) rs.getObject(2);
                Date date = (Date) rs.getObject(3);

                Order order = new Order(id, name, date);
                System.out.println(order);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, ps, rs);
        }
    }

    /*
    * @Author luolinyuan
    * @Description 针对于表的字段名和类的属性名不同的情况：
    *               必须使用SQL时 使用类的属性名来命名字段的别名
    *               使用ResultSetMetaData时需要使用getColumnLabel()获取列的别名(如果有)
    * @Date 2021/8/15
    * @Param [java.lang.String, java.lang.Object...]
    * @return jdbc_bean.Order
    **/
    public Order orderForQuery(String sql, Object... args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn=JDBCUtils.getConnection();
            ps=conn.prepareStatement(sql);

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
                Order order = new Order();

                for (int i = 0; i < columnCount; i++) {
                    //获取每个列的列值
                    Object columnValue = rs.getObject(i + 1);
                    //获取字段名而非别名
                    //String columnName = rsmd.getColumnName(i + 1);

                    //获取列的别名
                    String columnLable = rsmd.getColumnLabel(i+1);

                    //通过反射
                    Field field = Order.class.getDeclaredField(columnLable);
                    field.setAccessible(true);
                    field.set(order, columnValue);

                }
                return order;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, ps, rs);
        }
        return null;
    }

    @Test
    public void testOrderForQuery(){
        String sql="select order_id orderId,order_name " +
                "orderName,order_date orderDate from `order` where order_id=?";
        Order order=orderForQuery(sql,1);
        System.out.println(order);
    }

}
