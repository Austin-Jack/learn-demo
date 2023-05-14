package cn.llynsyw.spring.tx.service.impl;

import cn.llynsyw.spring.tx.dao.AccountDao;
import cn.llynsyw.spring.tx.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ,propagation = Propagation.REQUIRED)
    public void transfer(String outName, String inName, double money) {
        accountDao.out(outName, money);
        accountDao.in(inName, money);
    }
}
