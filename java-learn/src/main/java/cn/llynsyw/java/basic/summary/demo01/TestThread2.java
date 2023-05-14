package cn.llynsyw.java.basic.summary.demo01;


import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class TestThread2 extends Thread {
    private String url;  //网络图片地址
    private String filename; //保存文件名

    //构造方法
    public TestThread2(String url,String filename){
        this.filename=filename;
        this.url=url;
    }

    //重写run方法,执行下载图片
    public void run()
    {
        //生成一个下载器对象下载文件
        WebDownloader webDownloader=new WebDownloader();
        webDownloader.downloader(url,filename);
        System.out.println("下载了文件名为:"+filename);
    }

    //主方法
    public static void main(String[] args) {
        //构造三个线程对象分别下载图片
        TestThread2 t1=new TestThread2("http://llynsyw.cn/usr/uploads/bg1.jpg","1.jpg");
        TestThread2 t2=new TestThread2("http://llynsyw.cn/usr/uploads/bg1.jpg","2.jpg");
        TestThread2 t3=new TestThread2("http://llynsyw.cn/usr/uploads/bg1.jpg","3.jpg");

        //分别启动三个线程
        t1.start();
        t2.start();
        t3.start();

    }
}


//下载器
class WebDownloader {
    //下载方法
    public void downloader(String url, String fliename) {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(fliename));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常,downloader方法出现问腿");
        }
    }
}
