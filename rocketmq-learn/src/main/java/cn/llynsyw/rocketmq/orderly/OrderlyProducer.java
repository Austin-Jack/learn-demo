package cn.llynsyw.rocketmq.orderly;

import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Austin-Jack
 * @date 2023/5/29
 * 消息生产者
 */
public class OrderlyProducer {

    public static void main(String[] args) {
        DefaultMQProducer producer = null;
        try {
            // 1. 创建生产者对象 Producer 并绑定生产者组
            producer = new DefaultMQProducer("orderly-mq-producer");
            // 2. 设置 NameServer 地址
            producer.setNamesrvAddr("localhost:9876");
            // 3. 启动生产者对象
            producer.start();

            List<OrderStep> orders = buildOrders();

            // 循环发送订单消息
            for (OrderStep order : orders) {
                // 4. 创建一个消息对象，设置消息主题与内容
                Message message = new Message("create_order", JSON.toJSONString(order).getBytes());
                // 5. 生产者发送消息
                SendResult result = producer.send(message, new MessageQueueSelector() {

                    /**
                     * 发送消息时，选择消息发送到哪个消息队列
                     * @param list  消息队列列表
                     * @param message   消息对象
                     * @param orderId   send 方法传入的第三个参数的值
                     * @return
                     */
                    @Override
                    public MessageQueue select(List<MessageQueue> list, Message message, Object orderId) {
                        // 按照订单 id 对队列列表进行取余数，得到同一个订单消息应该去往同一个消息队列
                        long index = ((Long) orderId) % list.size();

                        // 返回对应的消息队列
                        return list.get((int) index);
                    }

                }, order.getOrderId());

                System.out.println("[" + new Date().toLocaleString() + "]消息发送完成：" + result.getSendStatus());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 6. 关闭生产者
            if (producer != null) {
                producer.shutdown();
            }
        }
    }

    /**
     * 订单的步骤
     */
    @Setter
    @Getter
    @ToString
    private static class OrderStep {
        private long orderId;//订单id
        private String desc;//订单说明: 创建,付款,推送,完成
    }

    /**
     * 生成模拟订单数据
     */
    private static List<OrderStep> buildOrders() {
        List<OrderStep> orderList = new ArrayList<OrderStep>();

        OrderStep orderDemo = new OrderStep();
        orderDemo.setOrderId(15103111039L);
        orderDemo.setDesc("创建1");
        orderList.add(orderDemo);

        orderDemo = new OrderStep();
        orderDemo.setOrderId(15103111065L);
        orderDemo.setDesc("创建1");
        orderList.add(orderDemo);

        orderDemo = new OrderStep();
        orderDemo.setOrderId(15103111039L);
        orderDemo.setDesc("付款2");
        orderList.add(orderDemo);

        orderDemo = new OrderStep();
        orderDemo.setOrderId(15103117235L);
        orderDemo.setDesc("创建1");
        orderList.add(orderDemo);

        orderDemo = new OrderStep();
        orderDemo.setOrderId(15103111065L);
        orderDemo.setDesc("付款2");
        orderList.add(orderDemo);

        orderDemo = new OrderStep();
        orderDemo.setOrderId(15103117235L);
        orderDemo.setDesc("付款2");
        orderList.add(orderDemo);

        orderDemo = new OrderStep();
        orderDemo.setOrderId(15103111065L);
        orderDemo.setDesc("完成3");
        orderList.add(orderDemo);

        orderDemo = new OrderStep();
        orderDemo.setOrderId(15103111039L);
        orderDemo.setDesc("推送3");
        orderList.add(orderDemo);

        orderDemo = new OrderStep();
        orderDemo.setOrderId(15103117235L);
        orderDemo.setDesc("完成3");
        orderList.add(orderDemo);

        orderDemo = new OrderStep();
        orderDemo.setOrderId(15103111039L);
        orderDemo.setDesc("完成4");
        orderList.add(orderDemo);
        return orderList;
    }
}
