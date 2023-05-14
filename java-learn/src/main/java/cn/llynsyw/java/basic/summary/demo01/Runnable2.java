package cn.llynsyw.java.basic.summary.demo01;

public class Runnable2 implements Runnable{
    private String url;  //网络图片地址
    private String filename; //保存文件名

    //构造方法
    public Runnable2(String url,String filename){
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

    public static void main(String[] args) {
        String url="https://gitee.com/llygitee/pic-go/raw/master/img/VSPIC1.jpg";

        //创建线程分别执行
        new Thread(new Runnable2(url,"4.jpg")).start();
        new Thread(new Runnable2(url,"5.jpg")).start();
        new Thread(new Runnable2(url,"6.jpg")).start();

    }
}
