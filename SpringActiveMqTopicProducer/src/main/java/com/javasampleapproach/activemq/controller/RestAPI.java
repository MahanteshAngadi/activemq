package com.javasampleapproach.activemq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javasampleapproach.activemq.jms.JmsPublisher;
import com.javasampleapproach.activemq.models.Device;

@CrossOrigin(origins = "*")
@RestController
public class RestAPI {
	
	@Autowired
	JmsPublisher jmsPublisher;
	
	@PostMapping(value="/api/store")
	public Device postCustomer(@RequestBody Device device){
		jmsPublisher.send(device);
		System.out.println("/api/store RestAPI postCustomer device = " + device);
		return device;
	}

	@PostMapping(value="/api/store/2")
	public Device postCustomer2(@RequestBody Device device){
		jmsPublisher.send(device);
		System.out.println("/api/store2 RestAPI postCustomer device = " + device);
		return device;
	}

}
