package com.javasampleapproach.activemq.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javasampleapproach.activemq.models.MessageStorage;
import com.javasampleapproach.activemq.models.Device;

@RestController
public class RestAPI {
	
	@Autowired
	private MessageStorage messageStorage;
	
	@CrossOrigin(origins = "*")
	@GetMapping(value="/api/devices/1")
	public List<Device> getAll1(){
		List<Device> devices = new ArrayList<Device>(messageStorage.getAll());
		messageStorage.clear();
		System.out.println("/api/tasks/1 RestAPI getAll devices = " + devices);
		return devices;
	}

	@CrossOrigin(origins = "*")
	@GetMapping(value="/api/devices/2")
	public List<Device> getAll2(){
		List<Device> devices = new ArrayList<Device>(messageStorage.getAll());
		messageStorage.clear();
		System.out.println("/api/tasks/2 RestAPI getAll devices = " + devices);
		return devices;
	}

	@CrossOrigin(origins = "*")
	@GetMapping(value="/api/devices/3")
	public List<Device> getAll3(){
		List<Device> devices = new ArrayList<Device>(messageStorage.getAll());
		messageStorage.clear();
		System.out.println("/api/tasks/3 RestAPI getAll devices = " + devices);
		return devices;
	}

}
