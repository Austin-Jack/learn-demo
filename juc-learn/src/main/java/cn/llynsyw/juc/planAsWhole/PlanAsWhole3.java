package cn.llynsyw.juc.planAsWhole;

import lombok.extern.slf4j.Slf4j;

import static cn.llynsyw.juc.util.Sleeper.sleep;

/**
 * @Description TODO
 * @Author luolinyuan
 * @Date 2022/4/2
 **/
@Slf4j
public class PlanAsWhole3 {
	static String kettle = "冷水";
	static String tea = null;
	static final Object lock = new Object();

	public static void makeTea() {
		new Thread(() -> {
			log.debug("洗水壶");
			sleep(1);
			log.debug("烧开水");
			sleep(5);
			synchronized (lock) {
				kettle = "开水";
				lock.notifyAll();
			}
		}, "老王").start();
		new Thread(() -> {
			log.debug("洗茶壶");
			sleep(1);
			log.debug("洗茶杯");
			sleep(2);
			log.debug("拿茶叶");
			sleep(1);
			synchronized (lock) {
				tea = "花茶";
				lock.notifyAll();
			}
		}, "小王").start();
		new Thread(() -> {
			synchronized (lock) {
				while (kettle.equals("冷水") || tea == null) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				log.debug("拿({})泡({})", kettle, tea);
			}
		}, "王夫人").start();
	}

	public static void main(String[] args) {
		makeTea();
	}
}