package cn.llynsyw.java.task.week02.hash;

public class HashCode {
    public static void main(String[] args) {
      /*  int[] numbers = {2, 5, 9, 13};
        findNumber(numbers, 3);//O(n)*/

        System.out.println("ABCDEa123abc".hashCode());
        System.out.println("ABCDFB123abc".hashCode());

    }

    public static boolean findNumber(int[] numbers, int number) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == number) {
                return true;
            }
        }
        return false;
    }


}
