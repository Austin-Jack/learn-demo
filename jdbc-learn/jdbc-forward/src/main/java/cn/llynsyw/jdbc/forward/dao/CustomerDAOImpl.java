package cn.llynsyw.jdbc.forward.dao;


import cn.llynsyw.jdbc.forward.bean.Customer;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

/**
 * @ClassName CustomerDAOImpl
 * @Description
 * @package jdbc_dao
 * @Author luolinyuan
 * @Date 2021/8/17
 **/
public class CustomerDAOImpl extends BaseDAO<Customer> implements CustomerDAO{


    @Override
    public void insert(Connection conn, Customer customer) {
        String sql="insert into customers(name,email,birth) values (?,?,?)";
        update(conn,sql,customer.getName(),customer.getName(),customer.getBirth());
    }

    @Override
    public void deleteByID(Connection conn, int id) {
        String sql="delete from customers where id = ?";
        update(conn,sql,id);
    }

    @Override
    public void update(Connection conn, Customer customer) {
        String sql="update customers set name =?, email = ?,birth= ? where id=?";
        update(conn,sql,customer.getName(),customer.getEmail(),customer.getBirth(),customer.getId());

    }

    @Override
    public Customer getCustomerByID(Connection conn, int id) {
        String sql="select id,name,email,birth from customers where id = ?";
        Customer customer=getInstance(conn,sql,id);
        return customer;
    }

    @Override
    public List<Customer> getAll(Connection conn) {
        String sql="select id,name,email,birth from customers";
        List<Customer> list=getForList(conn,sql);
        return list;
    }

    @Override
    public Long getCount(Connection conn) {
        String sql="select count(*) from customers";
        return getValue(conn, sql);
    }

    @Override
    public Date getMaxBirth(Connection conn) {
        String sql="select max(birth) from customers";
        return getValue(conn, sql);
    }

}
