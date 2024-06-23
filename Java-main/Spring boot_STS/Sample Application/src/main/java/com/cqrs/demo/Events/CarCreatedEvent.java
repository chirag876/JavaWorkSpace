package com.cqrs.demo.Events;

import lombok.Data;

@Data
public class CarCreatedEvent {

	private int Id;
	private String Name;
	private String Model;
	public CarCreatedEvent(int id, String name, String model) {
		super();
		Id = id;
		Name = name;
		Model = model;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getModel() {
		return Model;
	}
	public void setModel(String model) {
		Model = model;
	}
	
	
	
	
}
