package com.cqrs.demoCommand;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.Data;

@Data
public class CreateCarCommand {

	@TargetAggregateIdentifier
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
	
	public CreateCarCommand(int id, String name, String model) {

		Id = id;
		Name = name;
		Model = model;
	}
	
	
	
	
	
	
}
