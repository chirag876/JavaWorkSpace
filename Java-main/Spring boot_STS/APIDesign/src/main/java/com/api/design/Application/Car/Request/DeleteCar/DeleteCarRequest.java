package com.api.design.Application.Car.Request.DeleteCar;

import com.api.design.Mediator.Request;

public class DeleteCarRequest implements Request<Integer> {
	private int id;

	public DeleteCarRequest(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

}
