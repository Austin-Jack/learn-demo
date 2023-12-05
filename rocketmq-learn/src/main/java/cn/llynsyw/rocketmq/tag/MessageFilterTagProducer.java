package cn.llynsyw.rocketmq.tag;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

import java.util.Date;

/**
 * @author Austin-Jack
 * @date 2023/5/29
 * 消息生产者
 */
public class MessageFilterTagProducer {

    public static void main(String[] args) {
        DefaultMQProducer producer = null;
        try {
            // 1. 创建生产者对象 Producer 并绑定生产者组
            producer = new DefaultMQProducer("filter-tag-mq-producer");
            // 2. 设置 NameServer 地址
            producer.setNamesrvAddr("localhost:9876");
            // 3. 启动生产者对象
            producer.start();
            // 4. 创建一个消息对象，设置消息主题与内容
            Message message = new Message("filter-tag", "TAG_B", "这是消息过滤的消息内容".getBytes());
            // 5. 生产者发送消息
            SendResult result = producer.send(message);
            System.out.println("[" + new Date().toLocaleString() + "]消息发送完成：" + result.getSendStatus());
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
