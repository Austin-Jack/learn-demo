package cn.llynsyw.security.csrft.env.service;

import cn.llynsyw.security.csrft.env.entity.UserEntity;
import cn.llynsyw.security.csrft.env.utils.PageUtils;
import cn.llynsyw.security.csrft.env.vo.ExchangeVo;
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

