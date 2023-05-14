package cn.llynsyw.juc.design.terminate;

import lombok.extern.slf4j.Slf4j;

import static cn.llynsyw.juc.util.Sleeper.sleep;

/**
 * @Description TODO
 * @Author luolinyuan
 * @Date 2022/4/3
 **/
@Slf4j
public class StopMark {

	private Thread thread;
	private volatile boolean stop = false;

	public void start() {
		thread = new Thread(() -> {
			while (true) {
				Thread current = Thread.currentThread();
				if (stop) {
					log.debug("料理后事");
					break;
				}
				try {
					Thread.sleep(1000);
					log.debug("将结果保存");
				} catch (InterruptedException e) {

				}
				// 执行监控操作
			}
		}, "监控线程");
		thread.start();
	}

	public void stop() {
		stop = true;
		thread.interrupt();
	}

	public static void main(String[] args) {
		IsInterrupted t = new IsInterrupted();
		t.start();

		sleep(3.5);
		log.debug("stop the thread");
		t.stop();
	}
}

