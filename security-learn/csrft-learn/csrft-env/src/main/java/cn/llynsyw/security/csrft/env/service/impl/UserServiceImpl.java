package cn.llynsyw.security.csrft.env.service.impl;

import cn.llynsyw.security.csrft.env.dao.UserDao;
import cn.llynsyw.security.csrft.env.entity.UserEntity;
import cn.llynsyw.security.csrft.env.vo.ExchangeVo;
import cn.llynsyw.security.csrft.env.service.UserService;
import cn.llynsyw.security.csrft.env.utils.PageUtils;
import cn.llynsyw.security.csrft.env.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import org.springframework.transaction.annotation.Transactional;


@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements UserService {
     private static Integer EXCHANGE_POINT =10;

    @Autowired
    UserDao userDao;

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
        //UserEntity user = getOne(new QueryWrapper<UserEntity>().eq("username", userEntity.getUsername()).eq("password", userEntity.getPassword()));
        UserEntity user = userDao.selectOne(userEntity.getUsername(), userEntity.getPassword());
        return user;
    }

    @Transactional
    @Override
    public void exchange(ExchangeVo exchangeVo) {
        Integer send = userDao.reducePoint(exchangeVo.getSenderQQ(), EXCHANGE_POINT);
        if(send==1){
            Integer receive = userDao.addCard(exchangeVo.getReceiverQQ(), 1);
            if(receive!=1){
                throw new RuntimeException("接收者接受失败");
            }
        }else{
            throw new RuntimeException("兑换失败，积分不足");
        }
    }



}