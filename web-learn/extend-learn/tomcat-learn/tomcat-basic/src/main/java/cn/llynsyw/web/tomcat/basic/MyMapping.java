package cn.llynsyw.web.tomcat.basic;

import java.util.HashMap;

/**
 * @ClassName MyMapping
 * @Description
 * @package com.mashibing
 * @Author luolinyuan
 * @Date 2021/9/21
 **/
public class MyMapping {
    public static HashMap<String,String> mapping=new HashMap<>();
    static {
        mapping.put("/mytomcat","com.mashibing.MyServlet");
    }
    public static HashMap<String,String> getMapping(){
        return mapping;
    }
}
