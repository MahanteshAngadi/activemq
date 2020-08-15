package com.javasampleapproach.activemq.models;

public class Device {
	
	private String id;
	private String name;
	
	public Device() {
		super();
	}

	public Device(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", name=" + name + "]";
	}
	
	
}
