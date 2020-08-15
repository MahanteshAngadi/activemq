package com.javasampleapproach.activemq.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;


import org.springframework.stereotype.Component;


import com.javasampleapproach.activemq.models.Company;
import com.javasampleapproach.activemq.models.MessageStorage;
import com.javasampleapproach.activemq.models.Device;

@Component
public class JmsSubcriber {
	
	@Autowired
	private MessageStorage messageStorage;
	
	@JmsListener(destination = "${jsa.activemq.topic}")
	public void receive(Device device){
		// System.out.println("JmsSubcriber receive device first = " + device);
		// System.out.println("JmsSubcriber receive messageStorage first = " + messageStorage);
		messageStorage.add(device);
		// System.out.println("JmsSubcriber receive messageStorage next = " + messageStorage);
		System.out.println("JmsSubcriber receive device next = " + device);
	}
}
