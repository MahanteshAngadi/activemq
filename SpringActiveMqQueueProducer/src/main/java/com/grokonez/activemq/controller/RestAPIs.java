package com.grokonez.activemq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.grokonez.activemq.jms.producer.JmsProducer;
import com.grokonez.activemq.model.Device;

@CrossOrigin(origins = "*")
@RestController
public class RestAPIs {
	
	@Autowired
	JmsProducer jmsProducer;
	
	@CrossOrigin(origins = "*")
	@PostMapping(value="/api/devices")
	public Device postCustomer(@RequestBody Device device){
		jmsProducer.send(device);
		System.out.println("/api/devices RestAPI postCustomer device = " + device);
		return device;
	}
}
