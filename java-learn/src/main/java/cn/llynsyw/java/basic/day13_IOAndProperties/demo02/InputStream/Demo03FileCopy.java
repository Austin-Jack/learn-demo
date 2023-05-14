package cn.llynsyw.java.basic.day13_IOAndProperties.demo02.InputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo03FileCopy {
    public static void main(String[] args) throws IOException {
        FileInputStream fis=new FileInputStream("D:\\IdeaProjects\\basic-code\\13_IOAndProperties\\1.jpg");
        FileOutputStream fos=new FileOutputStream("D:\\IdeaProjects\\basic-code\\13_IOAndProperties\\2.jpg");
        byte[] bytes=new byte[1024];
        int len;
        while((len=fis.read(bytes))!=-1)
        {
            fos.write(bytes,0,len);
        }
        //先关闭写的，后关闭读的，如果写完了肯定读取完毕了
        fos.close();
        fis.close();

    }
}
