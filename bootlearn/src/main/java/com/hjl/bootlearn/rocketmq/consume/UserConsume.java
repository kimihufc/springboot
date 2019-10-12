package com.hjl.bootlearn.rocketmq.consume;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created with IntelliJ IDEA.
 * User: hjl
 * Date: 19-10-12
 * Time: 下午2:52
 * Description:
 */
@Component
public class UserConsume {

    @PostConstruct
    public void consume() throws Exception{
        DefaultMQPushConsumer consumer = new  DefaultMQPushConsumer("testgroup");
        consumer.setNamesrvAddr("172.26.8.80:9876");
        consumer.subscribe("mytopic","mytop");
        consumer.registerMessageListener((MessageListenerConcurrently)(list,context)->{
            for (MessageExt messageExt : list) {
                System.out.println("UserConsume="+new String(messageExt.getBody()));
            }
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        });
        consumer.start();
    }

}
