package com.cqrs.demo.Entity;


import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@javax.persistence.Entity
public class Car {

	@javax.persistence.Id
	private int Id;
	private String Name;
	private String Model;
	
	
	
	public Car(int id, String name, String model) {
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
