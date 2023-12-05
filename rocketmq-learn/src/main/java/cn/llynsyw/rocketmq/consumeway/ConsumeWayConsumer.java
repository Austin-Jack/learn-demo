package cn.llynsyw.rocketmq.consumeway;

import org.apache.rocketmq.client.consumer.DefaultMQPullConsumer;
import org.apache.rocketmq.client.consumer.PullResult;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.message.MessageQueue;

import java.util.List;

/**
 * @author Austin-Jack
 * @date 2023/5/29
 * 消息消费者
 */
public class ConsumeWayConsumer {

    public static void main(String[] args) {
        DefaultMQPullConsumer consumer = null;
        try {
            // 1. 创建消费者对象并绑定消费者组
            consumer = new DefaultMQPullConsumer("consumer-way-mq-consumer");
            // 2. 设置 NameServer 地址
            consumer.setNamesrvAddr("localhost:9876");
            // 3. 启动消费者
            consumer.start();
            // 4. 向 MQ 拉取消息
            MessageQueue queue = new MessageQueue("consumer-way", "broker-a", 2);
            PullResult result = consumer.pull(queue, "*", 0, 2);
            List<MessageExt> list = result.getMsgFoundList();
            for (MessageExt messageExt : list) {
                System.out.println("拉取到的消息：" + new String(messageExt.getBody()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 6. 关闭消费者
            if (consumer != null) {
                consumer.shutdown();
            }
        }
    }
}
