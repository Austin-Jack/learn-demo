package cn.llynsyw.spring.tx.service;

public interface AccountService {
    void transfer(String outName,String inName,double money);
}
