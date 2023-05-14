package cn.llynsyw.work.system.stability.systemStability;

/**
 * 令牌桶算法是一种限流算法，通过控制令牌的发放速率和每次请求的令牌消耗量，
 * 来限制请求的速率，保护系统不被过度请求所压垮,
 * 与漏桶算法不相同的是令牌桶能应对突发情况一次性将桶里的令牌拿走。
 *
 * @author luolinyuan
 * @date 2023/2/21
 **/
public class TokenBucket {
	private final int capacity; // 桶的容量
	private final double rate; // 令牌发放速率
	private double tokens; // 当前令牌数量
	private long lastRefillTimestamp; // 上次补充令牌的时间戳

	public TokenBucket(int capacity, double rate) {
		this.capacity = capacity;
		this.rate = rate;
		this.tokens = capacity; // 初始化桶的令牌数量为满桶
		this.lastRefillTimestamp = System.currentTimeMillis();
	}

	public synchronized boolean takeToken() {
		refill(); // 补充令牌
		if (tokens < 1.0) {
			return false; // 令牌数量不足
		} else {
			tokens -= 1.0; // 消耗一个令牌
			return true;
		}
	}

	private void refill() {
		long now = System.currentTimeMillis();
		double secondsSinceLastRefill = (now - lastRefillTimestamp) / 1000.0;
		double newTokens = secondsSinceLastRefill * rate; // 计算新补充的令牌数量
		tokens = Math.min(tokens + newTokens, capacity); // 补充令牌，不超过桶的容量
		lastRefillTimestamp = now; // 更新上次补充令牌的时间戳
	}

	public static void main(String[] args) throws InterruptedException {
		TokenBucket tokenBucket = new TokenBucket(10, 2.0); // 桶容量为10，令牌发放速率为2.0

		for (int i = 0; i < 20; i++) {
			boolean allowed = tokenBucket.takeToken();
			System.out.println("current tokens' num:" + tokenBucket.tokens);
			if (allowed) {
				System.out.println("Request " + i + " is allowed.");
			} else {
				System.out.println("Request " + i + " is rejected.");
			}
			Thread.sleep(100); // 模拟请求间隔
		}
	}

}

