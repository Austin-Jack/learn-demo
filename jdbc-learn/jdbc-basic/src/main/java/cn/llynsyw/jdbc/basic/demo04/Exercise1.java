package cn.llynsyw.jdbc.basic.demo04;

import cn.llynsyw.jdbc.basic.util.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

/**
 * @ClassName Exercise1
 * @Description
 * @package jdbc_exercise
 * @Author luolinyuan
 * @Date 2021/8/15
 **/
public class Exercise1 {

    @Test
    public void testInsert(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入用户名:");
        String name=scanner.next();
        System.out.println("请输入邮箱:");
        String email=scanner.next();
        System.out.println("请输入生日：");
        String birthday=scanner.next();

        String sql="insert into customers(name,email,birth) values(?,?,?)";
        int insertCount = update(sql, name, email, birthday);

        if (insertCount >0){
            System.out.println("添加成功！");
        }else {
            System.out.println("添加失败！");
        }
    }

    //通用的增删改操作
    public int update(String sql,Object ... args){
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            //1.获取数据库的连接
            conn = JDBCUtils.getConnection();

            //2.获取PreparedStatement的实例 (或：预编译sql语句)
            ps = conn.prepareStatement(sql);
            //3.填充占位符
            for(int i = 0;i < args.length;i++){
                ps.setObject(i + 1, args[i]);
            }

            //如果执行的是查询操作有返回结果则返回ture
            //如果是增删改操作没有返回结果 返回false
           //ps.execute();

            //返回影响的行数
           return ps.executeUpdate();
        } catch (Exception e) {

            e.printStackTrace();
        }finally{
            //5.关闭资源
            JDBCUtils.closeResource(conn, ps);

        }
        return  0;
    }

}
