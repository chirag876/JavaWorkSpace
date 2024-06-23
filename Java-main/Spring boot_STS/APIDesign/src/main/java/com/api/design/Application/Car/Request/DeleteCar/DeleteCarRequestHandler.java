package com.api.design.Application.Car.Request.DeleteCar;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import com.api.design.Application.Common.Interface.ICarDataAccess;

import com.api.design.Mediator.RequestHandler;

@Component
public class DeleteCarRequestHandler implements RequestHandler<DeleteCarRequest, Integer> {

	@Autowired
	private ICarDataAccess _dataAccess;

	@Override
	public Integer handle(DeleteCarRequest command) {
		return _dataAccess.delete(command.getId());
	}
}
