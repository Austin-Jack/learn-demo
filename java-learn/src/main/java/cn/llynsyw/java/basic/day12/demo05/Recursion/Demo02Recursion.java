package cn.llynsyw.java.basic.day12.demo05.Recursion;

import java.io.File;

//使用递归打印多级文件夹
public class Demo02Recursion {
    public static void main(String[] args) {
        printFileName("D:\\i4Tools7");
    }

    public static void printFileName(String name) {
        File file = new File(name);
        if (file.exists()) {
            File[] files = file.listFiles();
            for (File file1 : files) {
                if (file1.isDirectory()) {
                    String a = file1.getPath();
                    System.out.println(file1.getPath()+"--->目录下:");
                    printFileName(a);
                } else if (file1.isFile()) {
                    String a = file1.getPath();
                    System.out.println(a);
                }
            }
        }
    }
}
