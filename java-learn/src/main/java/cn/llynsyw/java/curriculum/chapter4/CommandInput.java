package cn.llynsyw.java.curriculum.chapter4;

public class CommandInput {

    public static void main(String[] args) {
        if (args.length == 0) {//判断agrs[]数组长度是否为0
            System.out.println("没有输入参数");
        } else {

            System.out.println("共输入" + args.length + "个参数");
            for (int i = 0; i < args.length; i++) {//依次遍历输出输入的参数值
                System.out.println(args[i]);
            }
        }
    }
}
