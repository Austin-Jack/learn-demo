package cn.llynsyw.juc.util;

/**
 * @Description 封装sleep方法
 * @Author luolinyuan
 * @Date 2022/4/2
 **/

import java.util.concurrent.TimeUnit;

public class Sleeper {
	public static void sleep(int i) {
		try {
			TimeUnit.SECONDS.sleep(i);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void sleep(double i) {
		try {
			TimeUnit.MILLISECONDS.sleep((int) (i * 1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
