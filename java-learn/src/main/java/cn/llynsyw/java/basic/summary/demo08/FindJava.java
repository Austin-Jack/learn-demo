package cn.llynsyw.java.basic.summary.demo08;

import java.io.File;
import java.io.FileFilter;

public class FindJava {

    public  static void printJava(File file){
        File[] files=file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".java")||pathname.isDirectory();
            }
        });
        for(File f:files)
        {
            if(f.isFile()){
                System.out.println("文件名:"+f.getAbsolutePath());
            }else{
                printJava(f);
            }
        }
    }

    public static void main(String[] args) {
        File dir=new File(".\\summary\\");
        printJava(dir);
    }
}