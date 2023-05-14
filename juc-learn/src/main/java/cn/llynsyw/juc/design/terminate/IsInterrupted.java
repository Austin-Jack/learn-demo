package cn.llynsyw.juc.design.terminate;

import lombok.extern.slf4j.Slf4j;
import static cn.llynsyw.juc.util.Sleeper.sleep;

/**
 * @Description TODO
 * @Author luolinyuan
 * @Date 2022/4/3
 **/
@Slf4j
public class IsInterrupted {
	private Thread thread;

	public void start() {
		thread = new Thread(() -> {
			while (true) {
				Thread current = Thread.currentThread();
				if (current.isInterrupted()) {
					log.debug("料理后事");
					break;
				}
				try {
					Thread.sleep(1000);
					log.debug("将结果保存");
				} catch (InterruptedException e) {
					current.interrupt();
				}
				// 执行监控操作
			}
		}, "监控线程");
		thread.start();
	}

	public void stop() {
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
