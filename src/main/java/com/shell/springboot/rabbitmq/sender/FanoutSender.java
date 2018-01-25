package com.shell.springboot.rabbitmq.sender;

import com.shell.springboot.rabbitmq.constant.RabbitConstants;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 广播模式消息发送
 * Created by ganguixiang on 2018/1/25.
 */
@Component
public class FanoutSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String message = "this is fanout model message.";
        // 不需要指定routing-key，任意
        rabbitTemplate.convertAndSend(RabbitConstants.FANOUT_EXCHANGE, "",  message);
    }
}
