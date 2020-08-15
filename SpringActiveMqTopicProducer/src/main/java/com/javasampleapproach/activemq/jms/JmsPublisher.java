package com.javasampleapproach.activemq.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.javasampleapproach.activemq.models.Company;
import com.javasampleapproach.activemq.models.Device;

@Component
public class JmsPublisher {
	
	@Autowired
	JmsTemplate jmsTemplate;
	
	@Value("${jsa.activemq.topic}")
	String topic;
	
	public void send(Device device){
		// System.out.println("JmsPublisher send device first = " + device);
		// System.out.println("JmsPublisher send jmsTemplate first = " + jmsTemplate);
		
		String id = device.getId();
		jmsTemplate.convertAndSend(topic, device,messagePostProcessor -> {
	           messagePostProcessor.setStringProperty("deviceId", id);
	           return messagePostProcessor;
		});
	    
		// System.out.println("JmsPublisher send jmsTemplate next = " + jmsTemplate);
		System.out.println("JmsPublisher send device next = " + device);
	}
}
