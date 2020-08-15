package com.grokonez.activemq.jms.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.grokonez.activemq.model.Device;

@Component
public class JmsProducer {
	
	@Autowired
	JmsTemplate jmsTemplate;
	
	@Value("${gkz.activemq.queue}")
	String queue;
	
	public void send(Device device){
		// System.out.println("JmsProducer send device first = " + device);
		// System.out.println("JmsProducer send jmsTemplate first = " + jmsTemplate);
		jmsTemplate.convertAndSend(queue, device);
		// System.out.println("JmsProducer send jmsTemplate next = " + jmsTemplate);
		System.out.println("JmsProducer send device next = " + device);
	}
}