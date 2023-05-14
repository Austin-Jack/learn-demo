package cn.llynsyw.java.basic.day10.demo01;

//一个方法的参数列表中只允许存在一个可变参数,并且只能写在参数表末尾
public class Demo01Changeable {
    public static void main(String[] args) {
        try {
            int sum = demo01(1);
            System.out.println(sum);
            int sum2 = demo01();
            System.out.println(sum2);
        } catch (MyException e) {
            System.out.println(e);
        }
    }

    private static int demo01(int... arr) throws MyException {
        int sum = 0;
        if (arr.length != 0) {
            for (int i : arr) {
                sum += i;
            }
        } else {
            throw new MyException("至少输入一个参数");
        }

        return sum;
    }
}
