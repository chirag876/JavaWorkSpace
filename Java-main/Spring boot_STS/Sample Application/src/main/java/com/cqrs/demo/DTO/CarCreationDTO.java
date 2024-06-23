package com.cqrs.demo.DTO;

import lombok.Value;

@Value
public class CarCreationDTO {

	private final int Id;
private final String Name;
private final String Model;
public CarCreationDTO(int id, String name, String model) {
	super();
	Id = id;
	Name = name;
	Model = model;
}
public int getId() {
	return Id;
}

public String getName() {
	return Name;
}

public String getModel() {
	return Model;
}





}
