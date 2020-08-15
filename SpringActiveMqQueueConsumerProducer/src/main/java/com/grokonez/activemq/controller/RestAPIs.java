package com.grokonez.activemq.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.grokonez.activemq.jms.consumer.JmsConsumer;
import com.grokonez.activemq.jms.producer.JmsProducer;
import com.grokonez.activemq.model.MessageStorage;
import com.grokonez.activemq.model.Device;

@CrossOrigin(origins = "*")
@RestController
public class RestAPIs {
	
	@Autowired
	JmsProducer jmsProducer;

	@Autowired
	private MessageStorage deviceStorage;

	@PostMapping(value="/api/devices")
	public Device postCustomer(@RequestBody Device device){
		jmsProducer.send(device);
		return device;
	}
	
	@GetMapping(value="/api/store")
	public List<Device> getAll(){
		List<Device> devices = new ArrayList<Device>(deviceStorage.getAll());
		deviceStorage.clear();
		return devices;
	}

}
