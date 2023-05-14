package cn.llynsyw.web.tomcat.basic;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName MyServer
 * @Description
 * @package com.mashibing
 * @Author luolinyuan
 * @Date 2021/9/21
 **/
public class MyServer {
    public static void startServer(int port) throws Exception{
        ServerSocket serverSocket=new ServerSocket(port);
        Socket socket=null;
        while (true){
            socket=serverSocket.accept();
            InputStream inputStream=socket.getInputStream();
            OutputStream outputStream=socket.getOutputStream();
            MyResponse response=new MyResponse(outputStream);
            MyRequest request=new MyRequest(inputStream);

            String clazz=new MyMapping().getMapping().get(request.getRequestUrl());

            if (clazz!=null){
                Class<MyServlet> myServletClass=(Class<MyServlet>) Class.forName(clazz);
                MyServlet myServlet=myServletClass.newInstance();
                myServlet.service(request,response);
            }
        }

    }

    public static void main(String[] args) throws Exception {
        startServer(80);
    }
}
