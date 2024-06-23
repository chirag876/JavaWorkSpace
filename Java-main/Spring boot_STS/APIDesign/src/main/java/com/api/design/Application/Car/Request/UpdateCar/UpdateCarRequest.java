package com.api.design.Application.Car.Request.UpdateCar;

import com.api.design.Mediator.Request;

public class UpdateCarRequest implements Request<Integer> {
	
	private int id;
	private String Name;
	private String Model;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
