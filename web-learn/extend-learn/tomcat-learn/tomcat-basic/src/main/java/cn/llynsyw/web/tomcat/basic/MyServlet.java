package cn.llynsyw.web.tomcat.basic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * @ClassName MyHttpServlet
 * @Description
 * @package com.mashibing
 * @Author luolinyuan
 * @Date 2021/9/21
 **/
public class MyServlet extends MyHttpServer {
    static int count = 0;

    @Override
    public void doGet(MyRequest request, MyResponse response) throws Exception {
        File file=new File("text.txt");
        BufferedReader br=new BufferedReader(new FileReader(file));
        count++;
        if (count>6)
            count=(count%6);
        System.out.println(count);
        String s="";
        int lines=0;
        while(s!=null){
            lines++;
            s=br.readLine();
            if(lines>=count)
                break;
        }
        System.out.println(s);

        response.write(s);
    }

    @Override
    public void doPost(MyRequest request, MyResponse response) throws Exception {
        doGet(request, response);
    }
}
