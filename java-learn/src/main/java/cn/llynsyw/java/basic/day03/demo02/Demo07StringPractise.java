package cn.llynsyw.java.basic.day03.demo02;

import java.util.Scanner;

/*
将数组 [1,2,3]输出为 [word1#word2#word3]
键盘输入一个字符串，并且统计其中各种字符出现的次数
种类有：大写字母、小写字母、数字、其他。
 */
public class Demo07StringPractise {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 2, 3, 2, 3, 2, 3, 2, 32, 3, 2, 32, 3, 2, 4, 2, 4, 2, 3};
        String str = toString(nums);
        Scanner sc = new Scanner(System.in);
        String str2=new String();
        System.out.println("请输入一个字符串:");
        str2=sc.next();
        int intCount=0;
        int capitalCount=0;
        int lowercaseCount=0;
        int otherCount=0;
        char[] chars = str2.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char ch=chars[i];
            if('A'<=ch&&ch<='Z')
                capitalCount++;
            else if ('a'<=ch&&ch<='z')
                lowercaseCount++;
            else if('0'<=ch&&ch<='9')
                intCount++;
            else
                otherCount++;
        }
        System.out.println("所输入字符串当中数字有"+intCount+"个,"+"大写字母有"+capitalCount+"个,"
        +"小写字母有"+lowercaseCount+"个,"+"其他的有"+otherCount+"个。");


        // System.out.println(str);
    }

    public static String toString(int[] nums) {
        String str = "[";
        for (int i = 0; i < nums.length; i++) {

            if (i == nums.length - 1) {
                str += "word" + nums[i] + "]";
            } else {
                str += "world" + nums[i] + "#";
            }
        }
        return str;
    }


}
