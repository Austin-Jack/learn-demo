package cn.llynsyw.java.basic.day11.demo01;

public class Demo01Exception {
    public static void main(String[] args) throws Exception {
        //readFile("");
    }

    private static void readFile(String string) throws Exception {
        if (string!="c:\\a.txt"){
           throw  new Exception("路径不是c:\\a.txt");
        }

    }
}
