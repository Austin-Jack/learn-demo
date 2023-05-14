package cn.llynsyw.java.basic.summary.demo09;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class FileUpload_Server {
    public static void main(String[] args) throws IOException {
        System.out.println("服务器 启动.....");
        //创建服务端
        ServerSocket serverSocket = new ServerSocket(6660);
        //循环接收，建立连接
        while (true) {
            //建立连接
            Socket accept = serverSocket.accept();
            System.out.println("收到一个连接");
            new Thread(() -> {
                try {
                    //获取输入流对象
                    BufferedInputStream bis = new BufferedInputStream(accept.getInputStream());
                    //创建输出流对象
                    FileOutputStream fis = new FileOutputStream(System.currentTimeMillis() + ".accept");

                    BufferedOutputStream bos = new BufferedOutputStream(fis);

                    //读写数据
                    byte[] b = new byte[1024 * 8];
                    int len;
                    while ((len = bis.read(b)) != -1) {
                        bos.write(b, 0, len);
                    }


                    //释放资源
                    bos.close();
                    accept.close();
                    bis.close();
                    System.out.println("文件上床已保存");
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
            }).start();
        }

    }
}
