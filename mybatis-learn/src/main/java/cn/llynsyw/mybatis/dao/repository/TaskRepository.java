package cn.llynsyw.mybatis.dao.repository;

import cn.llynsyw.mybatis.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * TODO
 *
 * @author luolinyuan
 * @since 2023/9/1
 **/
@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
}
