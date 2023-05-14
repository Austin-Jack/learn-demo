package cn.llynsyw.java.basic.day02.demo01;

public class Demo01MethodOverload {
    public static void main(String[] args) {
        System.out.println(isSame((byte) 1, (byte) 1));
        System.out.println(isSame((short) 1, (short) 1));
        System.out.println(isSame(1, 1));
        System.out.println(isSame((long) 1, (long) 1));

    }

    public static boolean isSame(byte a, byte b) {
        System.out.println("第一个被调用");
        return a == b;
    }

    public static boolean isSame(short a, short b) {
        System.out.println("第二个被调用");
        return a == b;
    }

    public static boolean isSame(int a, int b) {
        System.out.println("第三个被调用");
        return a == b;
    }

    public static boolean isSame(long a, long b) {
        System.out.println("第四个被调用");
        return a == b;
    }


}
