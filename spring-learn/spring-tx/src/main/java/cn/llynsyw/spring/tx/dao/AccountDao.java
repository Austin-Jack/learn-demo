package cn.llynsyw.spring.tx.dao;

public interface AccountDao {
    void out(String name, double money);

    void in(String name, double money);
}
