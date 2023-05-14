package cn.llynsyw.juc.design.terminate;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.LockSupport;

import static cn.llynsyw.juc.util.Sleeper.sleep;

/**
 * @Description TODO
 * @Author luolinyuan
 * @Date 2022/4/3
 **/
@Slf4j
public class InterruptTest {
	public static void testInterrupt1() {
		Thread t1 = new Thread(() -> {
			sleep(1);
		}, "t1");
		t1.start();
		sleep(0.5);
		t1.interrupt();
		log.debug("t1 打断状态: {}", t1.isInterrupted());
	}

	public static void testInterrupt2() {
		Thread t2 = new Thread(() -> {
			while (!Thread.currentThread().isInterrupted()) {
				/*空转表示正常运行*/
			}
			log.debug("打断状态：{}", Thread.currentThread().isInterrupted());
		}, "t2");
		t2.start();
		sleep(0.5);
		t2.interrupt();
	}

	private static void testInterrupt3() throws InterruptedException {
		Thread t1 = new Thread(() -> {

			log.debug("park...");
			LockSupport.park();
			log.debug("unpark...");
			log.debug("打断状态:{}", Thread.currentThread().isInterrupted());

		}, "t1");
		t1.start();

		sleep(0.5);

		t1.interrupt();
	}

	public static void main(String[] args) throws InterruptedException {
		testInterrupt3();
	}
}
