package cn.llynsyw.juc.planAsWhole;

import lombok.extern.slf4j.Slf4j;

import static cn.llynsyw.juc.util.Sleeper.sleep;

/**
 * @Description TODO
 * @Author luolinyuan
 * @Date 2022/4/2
 **/
@Slf4j
public class PlanAsWhole2 {
	static String kettle = "冷水";
	static String tea = null;
	static final Object lock = new Object();
	static boolean made = false;

	public static void makeTea() {
		new Thread(() -> {
			log.debug("洗水壶");
			sleep(1);
			log.debug("烧开水");
			sleep(5);
			synchronized (lock) {
				kettle = "开水";
				lock.notifyAll();
				while (tea == null) {
					try {
						log.debug("等茶...");
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				if (!made) {
					log.debug("拿({})泡({})", kettle, tea);
					made = true;
				}
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
				while (kettle.equals("冷水")) {
					try {
						log.debug("等开水...");
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();

					}
				}
			}
			if (!made) {
				log.debug("拿({})泡({})", kettle, tea);
				made = true;
			}
		}, "小王").start();
	}

	public static void main(String[] args) {
		makeTea();
	}
}
