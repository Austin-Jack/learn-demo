package cn.llynsyw.mybatis.test;

import cn.llynsyw.mybatis.configuration.SqlSessionFactorySingleton;
import cn.llynsyw.mybatis.dao.mapper.UserMapper;
import cn.llynsyw.mybatis.domain.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestMybatis {
    @Test
    public void testRun() {
        //获取session工厂对象
        SqlSessionFactory sqlSessionFactory = SqlSessionFactorySingleton.getInstance();
        //获取session 最佳的作用域是请求或方法作用域 try-with-resource自动关闭
        try (SqlSession session = sqlSessionFactory.openSession()) {
            //获取对应的statement 执行操作
            // 第一种：命名空间+id的方式定位SQL语句
            List<User> userList1 = session.selectList("cn.llynsyw.mybatis.dao.mapper.UserMapper.findAll");
            // 或者直接使用id 不过此id需要全局唯一
            List<User> userList2 = session.selectList("findAll");
            //第二种：通过接口绑定的接口获取mapper然后调用方法 它不依赖于字符串字面值，会更安全一点
            List<User> userList3 = session.getMapper(UserMapper.class).findAll();
            Assert.assertEquals(userList1, userList2);
            Assert.assertEquals(userList2, userList3);
        }
    }

    @Test
    public void testIf() {
        try (SqlSession session = SqlSessionFactorySingleton.getInstance().openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            User user = new User();
            user.setId(2);
            List<User> userList = mapper.findByConditions(user);
            Assert.assertTrue(userList.size() > 0);
        }
    }

    @Test
    public void testSplitPage() {
        try (SqlSession session = SqlSessionFactorySingleton.getInstance().openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            /*设置分页参数*/
            PageHelper.startPage(2, 3);
            List<User> userList = mapper.findAll();
            for (User user : userList) {
                System.out.println(user);
            }

            /*获得与分页相关的参数*/
            PageInfo<User> pageInfo = new PageInfo<User>(userList);
            System.out.println("当前页 " + pageInfo.getPageNum());
            System.out.println("每条显示条数 " + pageInfo.getPageSize());
            System.out.println("总条数" + pageInfo.getTotal());
            System.out.println("总页数 " + pageInfo.getPages());
            System.out.println("上一页" + pageInfo.getPrePage());
            System.out.println("下一页" + pageInfo.getNextPage());
            System.out.println("是否为第一页" + pageInfo.isIsFirstPage());
            System.out.println("是否为最后一页" + pageInfo.isIsLastPage());
        }
    }

    @Test
    public void testFindByIds() {
        try (SqlSession session = SqlSessionFactorySingleton.getInstance().openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            List<Integer> userIds = new ArrayList<>();
            userIds.add(1);
            userIds.add(2);
            userIds.add(3);
            List<User> userList = mapper.findByIds(userIds);
            Assert.assertTrue(userList.size() > 0);
        }
    }

    @Test
    public void testTypeHandler() {
        try (SqlSession session = SqlSessionFactorySingleton.getInstance().openSession(true)) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            User user = new User();
            user.setUsername("testBirthday");
            user.setPassword("123");
            user.setBirthday(new Date());
            mapper.dateType(user);
        }
    }

    @Test
    public void testGetBirthday() {
        try (SqlSession session = SqlSessionFactorySingleton.getInstance().openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            User user = new User();
            user.setUsername("testBirthday");
            user = mapper.getBirthday(user);
            System.out.println(user);
        }
    }

    @Test
    public void test() {

        /*模拟User对象*/
        User user = new User();
        user.setUsername("testUpdate");
        user.setPassword("this is testUpdate");
        try (SqlSession session = SqlSessionFactorySingleton.getInstance().openSession(true)) {
            session.insert("save", user);
        }
    }

    @Test
    public void test3() {
        /*模拟User对象*/
        User user = new User();
        user.setId(1);
        user.setUsername("testUpdate");
        user.setPassword("测试改变密码");
        try (SqlSession session = SqlSessionFactorySingleton.getInstance().openSession(true)) {
            /*执行操作*/
            int updateRows = session.update("changePassword", user);
            Assert.assertEquals(1, updateRows);
        }
    }

    @Test
    public void test4() {
        try (SqlSession session = SqlSessionFactorySingleton.getInstance().openSession(true)) {
            /*执行操作*/
            int deleteRows = session.delete("deleteUser", 1);
            Assert.assertEquals(1, deleteRows);
        }
    }
}
