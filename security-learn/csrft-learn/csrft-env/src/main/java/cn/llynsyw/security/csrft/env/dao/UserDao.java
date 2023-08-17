package cn.llynsyw.security.csrft.env.dao;

import cn.llynsyw.security.csrft.env.entity.UserEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 
 * 
 * @author lly
 * @date 2021-04-22 23:22:54
 */
@Mapper
public interface UserDao extends BaseMapper<UserEntity> {
    @Update("update user set point=point-#{pointToReduce} where point>=#{pointToReduce} and username=#{senderQQ};")
    Integer reducePoint(@Param("senderQQ") String senderQQ, @Param("pointToReduce") Integer pointToReduce);

    @Update("update user set card=card+#{numToAdd} where username=#{receiverQQ};")
    Integer addCard(@Param("receiverQQ") String receiverQQ, @Param("numToAdd") int numToAdd);

    List<UserEntity> selectAll();

    @Select("SELECT * FROM user WHERE username=#{username} and password=#{password}")
    UserEntity selectOne(@Param("username") String username, @Param("password") String password);
}
