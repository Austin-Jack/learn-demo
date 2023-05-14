package cn.llynsyw.security.csrf.env.service;

import cn.llynsyw.security.csrf.env.entity.UserEntity;
import cn.llynsyw.security.csrf.env.utils.PageUtils;
import cn.llynsyw.security.csrf.env.vo.ExchangeVo;
import com.baomidou.mybatisplus.extension.service.IService;


import java.util.Map;

/**
 * 
 *
 * @author zy
 * @email zy@gmail.com
 * @date 2021-04-22 23:22:54
 */
public interface UserService extends IService<UserEntity> {

    PageUtils queryPage(Map<String, Object> params);

    UserEntity login(UserEntity userEntity);

    void exchange(ExchangeVo exchangeVo);
}

