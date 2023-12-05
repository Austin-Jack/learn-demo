package cn.llynsyw.rocketmq.hello;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

/**
 * @author Austin-Jack
 * @date 2023/5/29
 * 消息生产者
 */
public class HelloProducer {

    public static void main(String[] args) {
        // 需求：向 MQ 发送一条消息，消息内容为 hello rocketmq~~~~，主题为 hello-mq
        DefaultMQProducer producer = null;
        try {
            // 1. 创建生产者对象 Producer 并绑定生产者组
            producer = new DefaultMQProducer("hello-mq-producer");
            // 2. 设置 NameServer 地址
            producer.setNamesrvAddr("localhost:9876");
            // 3. 启动生产者对象
            producer.start();
            // 4. 创建一个消息对象，设置消息主题与内容
            Message message = new Message("hello-mq", "下课！！！！".getBytes());
            // 5. 生产者发送消息
            SendResult result = producer.send(message);
            System.out.println("消息发送完成：" + result.getSendStatus());
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
