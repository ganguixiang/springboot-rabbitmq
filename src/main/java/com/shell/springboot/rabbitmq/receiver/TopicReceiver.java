package com.shell.springboot.rabbitmq.receiver;

import com.shell.springboot.rabbitmq.constant.RabbitConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 主题模式消息接收
 *
 * 监听队列 test.topic.queue
 * Created by ganguixiang on 2018/1/25.
 */
@Component
@RabbitListener(queues = RabbitConstants.TOPIC_QUEUE)
public class TopicReceiver {

    private static final Logger LOGGER = LoggerFactory.getLogger(TopicReceiver.class);

    @RabbitHandler
    public void process(Object message) {
        LOGGER.info("receive message: {}", message);
    }
}

