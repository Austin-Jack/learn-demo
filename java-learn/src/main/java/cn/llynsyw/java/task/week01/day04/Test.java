package cn.llynsyw.java.task.week01.day04;

public class Test {
    public String convert(String s, int numRows) {
        if (s.length() <= numRows || numRows == 1){
            return s;
        }
        char[][] arr = new char[numRows][];
        int count = 0;
        int flag = 1;
        int nowRow = 0;
        int n = 0;
        for (int i = 0;i < s.length();i ++){
            arr[nowRow][n ++] = s.charAt(i);//这一行报空指针异常
            count ++;
            if (flag % 2 == 1){
                nowRow ++;
            }else{
                nowRow --;
            }
            if (count % (numRows - 1) == 0){
                flag ++;
            }
        }
        String res = new String();
        for(int i = 0;i < numRows;i ++){
            for(int j = 0;j < arr[i].length;j ++){
                if(arr[i][j] != '\u0000'){
                    res = res + arr[i][j];
                }
            }
        }
        return res;
    }
}
