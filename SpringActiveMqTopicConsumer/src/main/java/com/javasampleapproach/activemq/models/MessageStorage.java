package com.javasampleapproach.activemq.models;

import java.util.ArrayList;
import java.util.List;

public class MessageStorage {
	private List<Device> tasks = new ArrayList<Device>();
	
	public void add(Device task) {
		tasks.add(task);
	}
	
	public void clear() {
		tasks.clear();
	}
	
	public List<Device> getAll(){
		return tasks;
	}

	@Override
	public String toString() {
		return "MessageStorage [tasks=" + tasks + "]";
	}
	
}