package cn.llynsyw.rocketmq.sendway;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

import java.util.concurrent.CountDownLatch;

/**
 * @author Austin-Jack
 * @date 2023/5/29
 */
public class AsyncProducer {

    public static void main(String[] args) {
        DefaultMQProducer producer = null;
        try {
            // 1. 创建生产者对象，绑定生产者组
            producer = new DefaultMQProducer("sendway-async");
            // 2. 设置 NameServer 地址
            producer.setNamesrvAddr("localhost:9876");
            // 3. 启动生产者
            producer.start();
            // 4. 构建消息对象，设置主题与消息内容
            Message message = new Message("sendway", "async", "这是一个异步消息~~~".getBytes());

            // 面试题：如何知道一个异步线程什么时候执行完成？
            // 利用 JUC 下的 CountDownLatch 倒计时计数器工具实现
            final CountDownLatch latch = new CountDownLatch(1);

            // 5. 发送异步消息
            producer.send(message, new SendCallback() {
                // 异步线程执行
                @Override
                public void onSuccess(SendResult sendResult) {
                    // 消息发送成功的回调
                    System.out.println("[" + Thread.currentThread().getName() + "]异步发送成功：" + sendResult.getSendStatus());
                    // 数量 -1
                    latch.countDown();
                }

                @Override
                public void onException(Throwable throwable) {
                    // 消息发送失败的回调
                    throwable.printStackTrace();
                    // 数量 -1
                    latch.countDown();
                }
            });
            // 同步线程直接跳过，继续往后执行
            // 同步线程在此处利用 latch 进行阻塞，直到 latch 对象中的数值被减到 0 以后，此时线程才会继续往后执行
            System.out.println("[" + Thread.currentThread().getName() + "] 当前同步线程被阻塞");
            latch.await();
            System.out.println("[" + Thread.currentThread().getName() + "] 异步线程已经执行完毕，同步线程继续执行");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 6. 关闭生产者
            if (producer != null) {
                producer.shutdown();
            }
        }
    }
}
