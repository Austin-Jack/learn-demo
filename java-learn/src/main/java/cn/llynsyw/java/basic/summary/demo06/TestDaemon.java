package cn.llynsyw.java.basic.summary.demo06;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestDaemon {
    public static void main(String[] args) {
        Runnable runnable=new DameThread();
        Thread thread=new Thread(runnable);
        thread.setDaemon(true); //设置为守护线程
        thread.start();     //开始执行守护线程
    }
}

class DameThread implements Runnable
{
    @Override
    public void run() {
        try{
            Thread.sleep(1000);
            File f=new File("daemon.txt");
            FileOutputStream os=new FileOutputStream(f,true);
            os.write("daemon".getBytes());
            System.out.println("写入成功！");
        }catch (InterruptedException e)
        {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}