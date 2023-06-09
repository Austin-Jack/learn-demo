package cn.llynsyw.security.csrf.env.dao;

import cn.llynsyw.security.csrf.env.entity.UserEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 
 * 
 * @author zy
 * @email zy@gmail.com
 * @date 2021-04-22 23:22:54
 */
@Mapper
public interface UserDao extends BaseMapper<UserEntity> {

    Integer reducePoint(@Param("senderQQ") String senderQQ, @Param("pointToReduce") Integer pointToReduce);

    Integer addCard(@Param("receiverQQ") String receiverQQ, @Param("numToAdd") int numToAdd);

    List<UserEntity> selectAll();
}
