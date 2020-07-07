/**
Copyright (c) 2020 This Program is sole property of Manish Kumar written on 06-Jul-2020
 * 
 */
package com.manish.springboot.rabbitmq.producer;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.manish.springboot.rabbitmq.model.Department;
import com.manish.springboot.rabbitmq.model.Employee;

/**
 * @author Manish
 *
 */
@Component
public class RabbitMqProducer {

	@Autowired
    private AmqpTemplate amqpTemplate;
	
	@Value("${rabbitmq.exchange}")
	private String exchange;

	@Value("${rabbitmq.routingkey}")
	private String routingKey;

	@Scheduled(fixedDelay = 1000, initialDelay = 500)
	public void produce() {
		Employee employee = Employee
				.builder().address("Patna").depatments(
						Stream.of(Department.builder().departmentName("Technology").build()).collect(Collectors.toList()))
				.build();
		amqpTemplate.convertAndSend(exchange, employee);
		System.out.println("Send mesg = "+employee);

	}

}
