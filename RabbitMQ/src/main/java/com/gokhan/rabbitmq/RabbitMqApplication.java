package com.gokhan.rabbitmq;

import java.util.Date;
import java.util.UUID;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gokhan.rabbitmq.model.Notification;

@SpringBootApplication
public class RabbitMqApplication {

	public static void main(String[] args) {
		SpringApplication.run(RabbitMqApplication.class, args);




	}

}
