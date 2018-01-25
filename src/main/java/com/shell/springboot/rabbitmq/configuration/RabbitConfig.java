package com.shell.springboot.rabbitmq.configuration;

import com.shell.springboot.rabbitmq.constant.RabbitConstants;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * rabbit mq配置
 * Created by ganguixiang on 2018/1/25.
 */
@Configuration
public class RabbitConfig {

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(RabbitConstants.TOPIC_EXCHANGE);
    }

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(RabbitConstants.FANOUT_EXCHANGE);
    }

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(RabbitConstants.DIRECT_EXCHANGE);
    }

    @Bean
    public Queue topicQueue() {
        return new Queue(RabbitConstants.TOPIC_QUEUE);
    }

    @Bean
    public Queue directQueue() {
        return new Queue(RabbitConstants.DIRECT_QUEUE);
    }

    @Bean
    public Queue fanoutQueueOne() {
        return new Queue(RabbitConstants.FANOUT_QUEUE_ONE);
    }

    @Bean
    public Queue fanoutQueueTwo() {
        return new Queue(RabbitConstants.FANOUT_QUEUE_TWO);
    }



    /**
     * 绑定topicExchange和topicQueue对应的routing-key为test.topic.#
     *
     * 往topicExchange发送消息时，消息头中的routing-key只要是test.topic.开头，消息就会进入到topicQueue中
     * 如：test.topic.test, test.topic.queue.test都会进入到topicQueue中
     * 如：test.direct.test就不会进入到topicQueue中
     * @return
     */
    @Bean
    public Binding topicBinder() {
        return BindingBuilder.bind(topicQueue()).to(topicExchange()).with("test.topic.#");
    }

    /**
     * 绑定directExchange和directQueue并指定routing-key为test.direct
     *
     * 往directExchange发送消息时，只有消息头的routing-key为test.direct的消息才会进入到directQueue队列中
     * @return
     */
    @Bean
    public Binding directBinder() {
        return BindingBuilder.bind(directQueue()).to(directExchange()).with("test.direct");
    }

    /**
     * 绑定fanoutExchange和fanoutQueueOne
     *
     * 只要往fanoutExchange发送消息，消息就会进入fanoutQueueOne队列
     * @return
     */
    @Bean
    public Binding fanoutBinderOne() {
        return BindingBuilder.bind(fanoutQueueOne()).to(fanoutExchange());
    }

    /**
     * 绑定fanoutExchange和fanoutQueueTow
     *
     * 只要往fanoutExchange发送消息，消息就会进入fanoutQueueTwo队列
     * @return
     */
    @Bean
    public Binding fantouBinderTwo() {
        return BindingBuilder.bind(fanoutQueueTwo()).to(fanoutExchange());
    }
}
