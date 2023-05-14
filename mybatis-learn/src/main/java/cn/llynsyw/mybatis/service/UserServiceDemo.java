package cn.llynsyw.mybatis.service;

import cn.llynsyw.mybatis.domain.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserServiceDemo {
    static UserService mapper;

    public static void main(String[] args) throws IOException {
        /*获取核心配置文件*/
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        /*获取session工厂对象*/
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        /*获取session*/
        SqlSession session = sqlSessionFactory.openSession(true);
        mapper = session.getMapper(UserService.class);
        testFindAll();
        session.close();
    }

    public static void testIf() {
        User user = new User();
        user.setId(2);
        List<User> userList = mapper.findByConditions(user);
        System.out.println(userList);
    }


    public static void testFindAll() {
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

    public static void testForEach() {
        List<Integer> userIds = new ArrayList<>();
        userIds.add(1);
        userIds.add(2);
        userIds.add(3);
        List<User> userList = mapper.findByIds(userIds);
        System.out.println(userList);
    }

    public static void testTypeHandler() {
        User user = new User();
        user.setUsername("test");
        user.setPassword("123");
        user.setBirthday(new Date());
        mapper.dateType(user);
    }

    public static void testGetBirthday() {
        User user = new User();
        user.setId(8);
        user = mapper.getBirthday(user);
        System.out.println(user);

    }
}
