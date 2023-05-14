package cn.llynsyw.juc.planAsWhole;

import lombok.extern.slf4j.Slf4j;

import static cn.llynsyw.juc.util.Sleeper.*;

/**
 * @Description TODO
 * @Author luolinyuan
 * @Date 2022/4/2
 **/
@Slf4j
public class PlanAsWhole1 {
	public static void main(String[] args) {
		method1();
	}

	public static void method1() {
		Thread t1 = new Thread(() -> {
			log.debug("洗水壶");
			sleep(1);
			log.debug("烧开水");
			sleep(15);
		}, "老王");
		Thread t2 = new Thread(() -> {
			log.debug("洗茶壶");
			sleep(1);
			log.debug("洗茶杯");
			sleep(2);
			log.debug("拿茶叶");
			sleep(1);
			try {
				t1.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			log.debug("泡茶");
		}, "小王");
		t1.start();
		t2.start();
	}

}
