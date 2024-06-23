package com.api.design.Application.Car.Queries.GetCar;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.api.design.Domain.Entities.Car;

public class CarDTO {

	ModelMapper mapper = new ModelMapper();

	@Autowired
	private Car Car;
	private int id;

	private String name;

	private String model;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public String getModel() {
		return model;
	}

}
