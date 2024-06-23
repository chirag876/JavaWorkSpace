package com.api.design.Application.Car.Request.CreateCar;



import com.api.design.Mediator.Request;


public class CreateCarRequest implements Request<Integer> {


	private int Id;
	private String Name;
	private String Model;
	
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
	
	public CreateCarRequest(int id, String name, String model) {

		Id = id;
		Name = name;
		Model = model;
	}
	
	
	
	
	
	
	
}



