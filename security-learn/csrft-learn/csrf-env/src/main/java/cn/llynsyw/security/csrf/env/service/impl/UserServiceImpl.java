package cn.llynsyw.security.csrf.env.service.impl;

import cn.llynsyw.security.csrf.env.dao.UserDao;
import cn.llynsyw.security.csrf.env.entity.UserEntity;
import cn.llynsyw.security.csrf.env.vo.ExchangeVo;
import cn.llynsyw.security.csrf.env.service.UserService;
import cn.llynsyw.security.csrf.env.utils.PageUtils;
import cn.llynsyw.security.csrf.env.utils.Query;
import org.springframework.stereotype.Service;

import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import org.springframework.transaction.annotation.Transactional;


@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements UserService {
    Integer ExchangeCardPoint=10;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UserEntity> page = this.page(
                new Query<UserEntity>().getPage(params),
                new QueryWrapper<UserEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public UserEntity login(UserEntity userEntity) {
        UserEntity user = getOne(new QueryWrapper<UserEntity>().eq("username", userEntity.getUsername()).eq("password", userEntity.getPassword()));
        return user;
    }

    @Transactional
    @Override
    public void exchange(ExchangeVo exchangeVo) {
        Integer send = baseMapper.reducePoint(exchangeVo.getSenderQQ(), ExchangeCardPoint);
        if(send==1){
            Integer receive = baseMapper.addCard(exchangeVo.getReceiverQQ(), 1);
            if(receive!=1){
                throw new RuntimeException("接收者接受失败");
            }
        }else{
            throw new RuntimeException("兑换失败，积分不足");
        }
    }



}