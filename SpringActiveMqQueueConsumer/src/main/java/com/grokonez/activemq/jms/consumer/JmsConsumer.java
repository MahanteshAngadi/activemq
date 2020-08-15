package com.grokonez.activemq.jms.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.grokonez.activemq.model.MessageStorage;
import com.grokonez.activemq.model.Device;

@Component
public class JmsConsumer {
	@Autowired
	private MessageStorage deviceStorage;
	
	// @JmsListener(destination = "${gkz.activemq.queue}", containerFactory="jsaFactory")
	@JmsListener(destination = "${gkz.activemq.queue}")
	public void receive(Device device){
		// System.out.println("JmsConsumer receive device first = " + device);
		deviceStorage.add(device);
		System.out.println("JmsConsumer receive device next = " + device);
	}
}