package cn.llynsyw.java.basic.day01;

public class Demo02Method {
    public static void main(String[] args) {
        PrintMethod();
    }

    public static void PrintMethod() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 20; j++) {
                System.out.print('*');
            }
            System.out.println();
        }
    }
}

