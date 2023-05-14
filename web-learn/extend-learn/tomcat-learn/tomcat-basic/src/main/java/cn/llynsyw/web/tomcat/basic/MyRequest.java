package cn.llynsyw.web.tomcat.basic;

import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName MyRequest
 * @Description
 * @package com.mashibing
 * @Author luolinyuan
 * @Date 2021/9/21
 **/
public class MyRequest {
    //请求方法
    private String requestMethod;

    //请求地址
    private String requestUrl;

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }


    public MyRequest(InputStream inputStream) throws IOException {
        //缓冲区
        byte[] buffer=new byte[1024];
        //读取数据长度
        int len=0;
        //定义请求的变量
        String str=null;

        if((len=inputStream.read(buffer))>0){
            str=new String(buffer,0,len);
        }
        //获取请求行
        String data = str.split("\n")[0];
        //分别获取请求方式和请求URl
        String[] params = data.split(" ");
        this.requestMethod=params[0];
        this.requestUrl=params[1];

    }
}
