package cn.llynsyw.juc.monitor;


import java.util.ArrayList;

/**
 * @Description 不安全的线程示例
 * @Author luolinyuan
 * @Date 2022/4/5
 **/
public class ThreadUnsafe {

	ArrayList<String> list = new ArrayList<>();
	static final int THREAD_NUMBER = 2;
	static final int LOOP_NUMBER = 200;

	public void method1(int loopNumber) {
		for (int i = 0; i < loopNumber; i++) {
			// { 临界区, 会产生竞态条件
			method2();
			method3();
		}
		// } 临界区
	}

	private void method2() {
		list.add("1");
	}

	private void method3() {
		list.remove(0);
	}

	public static void main(String[] args) {
		ThreadUnsafe test = new ThreadUnsafe();
		for (int i = 0; i < THREAD_NUMBER; i++) {
			new Thread(() -> {
				test.method1(LOOP_NUMBER);
			}, "Thread" + i).start();
		}
	}
}

