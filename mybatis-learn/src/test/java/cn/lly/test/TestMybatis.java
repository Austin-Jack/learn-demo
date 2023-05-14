package cn.lly.test;

import cn.llynsyw.mybatis.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMybatis {
    @Test
    public void test1() throws IOException {
        /*获取核心配置文件*/
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        /*获取session工厂对象*/
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        /*获取session*/
        SqlSession session = sqlSessionFactory.openSession();
        /*执行操作*/
        List<User> userList = session.selectList("userMapper.findAll");
        System.out.println(userList);
        /*释放资源*/
        session.close();
    }

    @Test
    public void test2() throws IOException {
        /*模拟User对象*/
        User user = new User();
        user.setUsername("testUpdate");
        user.setPassword("this is testUpdate");
        /*获取核心配置文件*/
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        /*获取session工厂对象*/
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        /*获取session*/
        SqlSession session = sqlSessionFactory.openSession();
        /*执行操作*/
        session.insert("userMapper.save", user);
        /*不会自动提交*/
        session.commit();
        /*释放资源*/
        session.close();
    }

    @Test
    public void test3() throws IOException {
        /*模拟User对象*/
        User user = new User();
        user.setId(1);
        user.setUsername("lly");
        user.setPassword("测试改变密码");
        /*获取核心配置文件*/
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        /*获取session工厂对象*/
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        /*获取session*/
        SqlSession session = sqlSessionFactory.openSession();
        /*执行操作*/
        int update = session.update("userMapper.changePassword", user);
        System.out.println(update);
        /*不会自动提交*/
        session.commit();
        /*释放资源*/
        session.close();
    }

    @Test
    public void test4() throws IOException {
        /*获取核心配置文件*/
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        /*获取session工厂对象*/
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        /*获取session*/
        SqlSession session = sqlSessionFactory.openSession();
        /*执行操作*/
        int delete = session.delete("userMapper.deleteUser", 1);

        System.out.println(delete);
        session.commit();
        session.close();
    }

    @Test
    public void test5() throws IOException {
        /*获取核心配置文件*/
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        /*获取session工厂对象*/
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        /*获取session*/
        SqlSession session = sqlSessionFactory.openSession();
        /*执行操作*/
        User user = session.selectOne("userMapper.findUserById", 2);
        System.out.println(user);
        /*释放资源*/
        session.close();
    }
}
