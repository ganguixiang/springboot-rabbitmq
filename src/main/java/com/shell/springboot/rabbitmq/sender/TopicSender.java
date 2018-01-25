package com.shell.springboot.rabbitmq.sender;

import com.shell.springboot.rabbitmq.constant.RabbitConstants;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 主题模式消息发送
 * Created by ganguixiang on 2018/1/25.
 */
@Component
public class TopicSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;


    public void send() {
        String message = "this is topic model message.";
        // routing-key必须与绑定的routing-key匹配
        rabbitTemplate.convertAndSend(RabbitConstants.TOPIC_EXCHANGE, "test.topic.test", message);
    }
}
