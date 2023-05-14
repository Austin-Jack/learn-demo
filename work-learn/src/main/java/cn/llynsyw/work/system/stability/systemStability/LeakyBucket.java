package cn.llynsyw.work.system.stability.systemStability;

/**
 * 漏铜算法能保证每个请求的负载时长，确定每秒能处理的请求数量
 *
 * @author luolinyuan
 * @date 2023/2/21
 **/

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class LeakyBucket {
	private long capacity; // 桶的容量
	private long outflowRate; // 水流出的速度，单位为毫秒
	private long waterLevel; //水桶中当前的水量
	private long lastLeakTime; // 上一次漏水的时间
	private ScheduledExecutorService scheduler;

	public LeakyBucket(long capacity, long outflowRate) {
		this.capacity = capacity;
		this.outflowRate = outflowRate;
		this.waterLevel = 0;
		this.lastLeakTime = System.currentTimeMillis();
		this.scheduler = new ScheduledThreadPoolExecutor(2);
	}

	/**
	 * 加水操作，返回是否成功加入水
	 */
	public synchronized boolean addWater() {
		long water = (long) (Math.random() * 2 * this.capacity + 1);
		System.out.println("来了" + water + "滴水..");
		// 先漏水
		leak();

		// 判断是否超过容量
		if (waterLevel + water > capacity) {
			System.out.println("水桶已满直接拒绝..");
			return false;
		}

		// 加入水
		waterLevel += water;
		System.out.println("加入了" + water + "滴水..");
		return true;
	}

	/**
	 * 漏水操作
	 */
	private synchronized void leak() {
		long now = System.currentTimeMillis();
		long timeSinceLastLeak = now - lastLeakTime;
		long leakedWater = timeSinceLastLeak * outflowRate;

		// 计算漏水后水桶中的水量
		waterLevel = Math.max(0, waterLevel - leakedWater);
		System.out.println("waterLevel: " + waterLevel + " leakedWater: " + leakedWater);

		// 更新上一次漏水的时间
		lastLeakTime = now;
	}

	/**
	 * 启动漏桶算法
	 */
	public void start() {
		scheduler.scheduleAtFixedRate(this::addWater, 1, 1, TimeUnit.SECONDS);
		scheduler.scheduleAtFixedRate(this::leak, 0, 3, TimeUnit.SECONDS);
	}

	public static void main(String[] args) {
		LeakyBucket leakyBucket = new LeakyBucket(5000, 3000);
		leakyBucket.start();
	}
}
