package com.grokonez.activemq.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grokonez.activemq.model.Device;
import com.grokonez.activemq.model.MessageStorage;

@CrossOrigin(origins = "*")
@RestController
public class RestAPIs {
	
	@Autowired
	private MessageStorage deviceStorage;
	
	@CrossOrigin(origins = "*")
	@GetMapping(value="/api/store")
	public List<Device> getAll(){
		List<Device> devices = new ArrayList<Device>(deviceStorage.getAll());
		deviceStorage.clear();
		return devices;
	}
	
}
