package cn.llynsyw.juc.monitor;

import org.openjdk.jol.info.ClassLayout;


/**
 * @Description 验证偏向锁对象头状态
 * @Author luolinyuan
 * @Date 2022/4/5
 * VMParameters -XX:BiasedLockingStartupDelay=0
 **/

class Person {
}

public class TestBiased {
	public static void main(String[] args) throws InterruptedException {
		Person person = new Person();

		Thread t1 = new Thread(() -> {
			synchronized (person) {
				System.out.println("--------------------------------------t1--------------------------------------");
				System.out.println(ClassLayout.parseInstance(person).toPrintable());
			}
			System.out.println(ClassLayout.parseInstance(person).toPrintable());
		});

		Thread t2 = new Thread(() -> {
			synchronized (person) {
				System.out.println("--------------------------------------t2--------------------------------------");
				System.out.println(ClassLayout.parseInstance(person).toPrintable());
			}
			System.out.println(ClassLayout.parseInstance(person).toPrintable());
		});

		t1.start();
		t1.join();
		t2.start();
	}
}

