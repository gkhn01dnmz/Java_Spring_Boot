package com.gokhan.rabbitmq.producer;

import java.util.Date;
import java.util.UUID;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.gokhan.rabbitmq.model.Notification;

import jakarta.annotation.PostConstruct;

@Service
public class NotificationProducer {


    @Value("${sr.rabbit.binding.name}")
    private  String bindingName;

    @Value("${sr.rabbit.exchange.name}")
    private  String exchangeName;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostConstruct
    public void init(){
        Notification notification = new Notification();
		notification.setNotificationId(UUID.randomUUID().toString());
		notification.setCreatedAt(new Date());
		notification.setMessage("Haydi kodlayalım platformuna hoş geldiniz");
		notification.setSeen(Boolean.FALSE);

        sendToQueue(notification);
    }

    public void sendToQueue(Notification notification){
        System.out.println("Notification Sent Id : " + notification.getNotificationId());
        rabbitTemplate.convertAndSend(exchangeName,bindingName,notification);
    }
}
