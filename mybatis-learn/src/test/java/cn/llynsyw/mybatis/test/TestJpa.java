package cn.llynsyw.mybatis.test;

import cn.llynsyw.mybatis.dao.repository.TaskRepository;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * TODO
 *
 * @author luolinyuan
 * @since 2023/9/1
 **/
@SpringBootTest
public class TestJpa {
    @Resource
    private TaskRepository taskRepository;

    @Test
    public void testSelectById() {
        System.out.println(taskRepository.findAll());
    }
}
