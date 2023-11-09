package com.gokhan.rabbitmq.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;

import org.springframework.stereotype.Service;

import com.gokhan.rabbitmq.model.Notification;


@Service
public class NotificationListener {
    


    @RabbitListener(queues = "queue-name")
    public void handleMessage(Notification notification){
        System.out.println("mesaj Alındı");
        System.out.println(notification.toString());
    }
}
