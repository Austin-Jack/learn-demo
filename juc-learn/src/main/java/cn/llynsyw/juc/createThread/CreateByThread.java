package cn.llynsyw.juc.createThread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

@Slf4j
public class CreateByThread {
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(() -> log.debug("this is {}", Thread.currentThread().getName()));
		//t1.start();

		MyThread t2 = new MyThread();
		//t2.start();

		Thread t3 = new Thread(() -> log.debug("this is {}", Thread.currentThread().getName()));
		//t3.start();
		FutureTask<String> info = new FutureTask(new Callable() {
			@Override
			public Object call() throws Exception {
				return Thread.currentThread().getName();
			}
		});
		Thread t4 = new Thread(info);
		t4.start();
		try {
			//调用该方法会阻塞，直到获取到返回值
			String s = info.get();
			System.out.println(s);
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
}

@Slf4j
class MyThread extends Thread {
	@Override
	public void run() {
		log.debug("this is {}", Thread.currentThread().getName());
	}
}

