package cn.llynsyw.rocketmq.sendway;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;

/**
 * @author Austin-Jack
 * @date 2023/5/29
 */
public class OneWayProducer {

    public static void main(String[] args) {
        DefaultMQProducer producer = null;
        try {
            // 1. 创建生产者对象，绑定生产者组
            producer = new DefaultMQProducer("sendway-oneway");
            // 2. 设置 NameServer 地址
            producer.setNamesrvAddr("localhost:9876");
            // 3. 启动生产者
            producer.start();
            // 4. 构建消息对象，设置主题与消息内容
            Message message = new Message("sendway", "oneway", "这是一个单向消息~~~".getBytes());

            // 5. 发送异步消息
            producer.sendOneway(message);
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
