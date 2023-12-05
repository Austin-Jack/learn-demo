package cn.llynsyw.rocketmq.orderly;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.*;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author Austin-Jack
 * @date 2023/5/29
 * 消息消费者
 */
public class OrderlyConsumer {

    public static void main(String[] args) {
        DefaultMQPushConsumer consumer = null;
        try {
            // 1. 创建消费者对象并绑定消费者组
            consumer = new DefaultMQPushConsumer("orderly-mq-consumer");
            // 2. 设置 NameServer 地址
            consumer.setNamesrvAddr("localhost:9876");
            // 3. 订阅消费消息的主题
            consumer.subscribe("create_order", "*");
            // 4. 设置并创建顺序消费消息监听器
            consumer.setMessageListener(new MessageListenerOrderly() {
                @Override
                public ConsumeOrderlyStatus consumeMessage(List<MessageExt> list, ConsumeOrderlyContext consumeOrderlyContext) {
                    // 4.1 在监听器中消费消息
                    for (MessageExt messageExt : list) {
                        System.out.println("[" + new Date().toLocaleString() + "]消费消息：" + new String(messageExt.getBody()));
                    }
                    return ConsumeOrderlyStatus.SUCCESS;
                }
            });
            // 5. 启动消费者
            consumer.start();
            // ------------------------ 等待消息消费完毕后再关闭 ---------------------
            TimeUnit.HOURS.sleep(1);
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
