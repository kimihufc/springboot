package com.hjl.bootlearn.rocketmq.produce;

import com.alibaba.fastjson.JSON;
import com.hjl.bootlearn.rocketmq.User;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created with IntelliJ IDEA.
 * User: hjl
 * Date: 19-10-12
 * Time: 下午2:41
 * Description:
 */
@Component
public class UserProduce {

    @PostConstruct
    public void produce()throws Exception{
        DefaultMQProducer producer = new DefaultMQProducer("testgroup");
        producer.setNamesrvAddr("172.26.8.80:9876");
        producer.start();
        for (int i = 0; i < 5 ; i++) {
            User user = new User();
            user.setName("test"+i);
            user.setAge(i);
            Message mes = new Message("mytopic","mytop", JSON.toJSONString(user).getBytes("UTF-8"));
            SendResult result = producer.send(mes);
            System.out.println(JSON.toJSONString(result));
        }
        producer.shutdown();
    }

}
