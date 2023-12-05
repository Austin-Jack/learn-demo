package cn.llynsyw.mybatis;

import cn.llynsyw.mybatis.dao.repository.TaskRepository;
import cn.llynsyw.mybatis.domain.Task;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * TODO
 *
 * @author luolinyuan
 * @since 2023/9/1
 **/
@SpringBootApplication
public class App {
    @Resource
    TaskRepository taskRepository;
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @PostConstruct
    public void test(){
        taskRepository.save(new Task(null, false));
    }
}
