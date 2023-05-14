package cn.llynsyw.web.tomcat.basic;


/**
 * @ClassName HttpServer
 * @Description
 * @package com.mashibing
 * @Author luolinyuan
 * @Date 2021/9/21
 **/
public abstract class MyHttpServer {
    public static final String METHOD_GET="GET";
    public static final String METHOD_POST="POST";
    public abstract void doGet(MyRequest request,MyResponse response) throws Exception;
    public abstract void doPost(MyRequest request,MyResponse response) throws Exception;

    public void service(MyRequest request,MyResponse response) throws Exception {
        if (METHOD_GET.equals(request.getRequestMethod())){
            doGet(request,response);
        }
        if (METHOD_POST.equals(request.getRequestMethod())){
            doPost(request,response);
        }
    }
}
