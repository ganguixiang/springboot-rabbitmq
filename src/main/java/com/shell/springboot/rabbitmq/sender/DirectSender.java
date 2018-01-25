package com.shell.springboot.rabbitmq.sender;

import com.shell.springboot.rabbitmq.constant.RabbitConstants;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 直连模式消息发送
 * Created by ganguixiang on 2018/1/25.
 */
@Component
public class DirectSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String message = "this is direct model message.";
        // routing-key必须与绑定的routing-key一致
        rabbitTemplate.convertAndSend(RabbitConstants.DIRECT_EXCHANGE, "test.direct", message);
    }
}
