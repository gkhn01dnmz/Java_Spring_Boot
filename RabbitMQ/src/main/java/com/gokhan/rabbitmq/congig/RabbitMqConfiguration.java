package com.gokhan.rabbitmq.congig;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfiguration {

    @Value("${sr.rabbit.queue.name}")
    private  String qName;
    @Value("${sr.rabbit.binding.name}")
    private  String bindingName;
    @Value("${sr.rabbit.exchange.name}")
    private  String exchangeName;

    @Autowired
    private RabbitTemplate rabbitTemplate;


    @Bean
    public Queue queue(){
        return new Queue(qName);
    }

    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange(exchangeName);
    }

    @Bean
    public Binding binding(final Queue queue, final DirectExchange directExchange){
        return  BindingBuilder.bind(queue).to(directExchange).with(bindingName);
    }
}
