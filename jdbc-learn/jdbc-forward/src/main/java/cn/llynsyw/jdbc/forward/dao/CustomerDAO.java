package cn.llynsyw.jdbc.forward.dao;


import cn.llynsyw.jdbc.forward.bean.Customer;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

/*
* @Author luolinyuan
* @Description 用于规范针对customers表的常用操作
* @Date 2021/8/17
**/
public interface CustomerDAO {
    /*
    * @Author luolinyuan
    * @Description 将customer对象添加到数据库中
    * @Date 2021/8/17
    * @Param [java.sql.Connection, jdbc_bean.Customer]
    * @return void
    **/
    void insert(Connection conn, Customer customer);

    /*
    * @Author luolinyuan
    * @Description 针对指定的id删除表中的一条记录
    * @Date 2021/8/17
    * @Param [java.sql.Connection, int]
    * @return void
    **/
    void deleteByID(Connection conn,int id);

    /*
    * @Author luolinyuan
    * @Description 针对内存中的customer对象修改数据表中的记录
    * @Date 2021/8/17
    * @Param [java.sql.Connection]
    * @return void
    **/
    void update(Connection conn,Customer customer);

    /*
    * @Author luolinyuan
    * @Description 针对指定的id查询得到对应的Customer对象
    * @Date 2021/8/17
    * @Param [java.sql.Connection, int]
    * @return void
    **/
    Customer getCustomerByID(Connection conn,int id);

    /*
    * @Author luolinyuan
    * @Description 查询表中的所有customer对象
    * @Date 2021/8/17
    * @Param [java.sql.Connection]
    * @return java.util.List<jdbc_bean.Customer>
    **/
    List<Customer> getAll(Connection conn);
    
    /*
    * @Author luolinyuan
    * @Description 返回数据表中数据的条目数
    * @Date 2021/8/17
    * @Param [java.sql.Connection]
    * @return java.lang.Long
    **/
    Long getCount(Connection conn);
    
    /*
    * @Author luolinyuan
    * @Description 返回数据表的最新的生日日期
    * @Date 2021/8/17
    * @Param [java.sql.Connection]
    * @return java.util.Date
    **/
    Date getMaxBirth(Connection conn);
    
}
