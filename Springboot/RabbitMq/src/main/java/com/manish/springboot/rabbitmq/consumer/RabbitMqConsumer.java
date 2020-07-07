/**
Copyright (c) 2020 This Program is sole property of Manish Kumar written on 06-Jul-2020
 * 
 */
package com.manish.springboot.rabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.manish.springboot.rabbitmq.model.Employee;

/**
 * @author Manish
 *
 */
@Component
public class RabbitMqConsumer {
	
	
	@RabbitListener(queues = "${rabbitmq.queue}")
	public void receivedMessages(Employee employee) {
		System.out.println(employee);
		
	}

}
