package cn.llynsyw.juc.monitor;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description 测试并发下的问题
 * @Author luolinyuan
 * @Date 2022/4/3
 **/
@Slf4j
public class concurrent_pro {
	static int counter = 0;

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 5000; i++) {
				counter++;
			}
		}, "t1");
		Thread t2 = new Thread(() -> {
			for (int i = 0; i < 5000; i++) {
				counter--;
			}
		}, "t2");
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		log.debug("counter: {}", counter);
	}
}

