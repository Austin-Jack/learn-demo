package cn.llynsyw.spring.test;

import cn.llynsyw.spring.test.pojo.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"classpath:applicationContext.xml"})
public class SpringJunit {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    public void testInsert() {
        int row = jdbcTemplate.update("insert into account values (?,?)", "刘畅", 999999999);
        System.out.println(row);
    }

    @Test
    public void testQueryAll() {
        List<Account> list = jdbcTemplate.query("select * from account", new BeanPropertyRowMapper<>(Account.class));
        for (Account account : list) {
            System.out.println(account);
        }
    }

    @Test
    public void testUpdate() {
        int row = jdbcTemplate.update("update account set money = ? where name = ?", 999999999, "罗林园");
        System.out.println(row);
    }

    @Test
    public void testQueryOne() {
        Account account= (Account) jdbcTemplate.queryForObject("select name,money from account where name = ?",
                new BeanPropertyRowMapper<>(Account.class),"罗林园");
        System.out.println(account);
    }

    @Test
    public void testQueryCount() {
        Long aLong = jdbcTemplate.queryForObject("select count(*) from account", Long.class);
        System.out.println(aLong);
    }
}
