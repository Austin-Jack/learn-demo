package cn.llynsyw.java.basic.day08.demo01;

/*Math类包含各种数学工具
1.三角函数 返回值都是double类型的
2.指数：
exp(double a) e的a次方
log(double a) 取自然对数1lna
log10(double a) 10为底
sqrt(double a) 平方根
cbrt(double a) 立方根
pow(double a,double b) a的b次方
3.取整函数
public static double abs(double num) 获取绝对值，有多种重载
public static double ceil (double num) 向上取整
public static double floor(double num) 向下取整
public static long round (double num)  四舍五入
*/
public class MathDemo {
    public static void main(String[] args) {
        System.out.println(Math.sin(Math.PI/2));
        System.out.println(Math.cos(0));
        System.out.println(Math.acos(Math.sqrt(2)/2));
        //角度转换为弧度
        System.out.println(Math.toRadians(90));
        //弧度转换为角度
        System.out.println(Math.toDegrees(Math.PI/2));
    }
}
