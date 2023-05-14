package cn.spring.test.test;

import java.io.File;

/**
 * @Description TODO
 * @Author luolinyuan
 * @Date 2022/3/31
 **/
public class TestDelete {
    public static void main(String[] args) {
        File  dir = new File("dir");
        dir.delete();

        System.out.println(dir == null);
    }
}
