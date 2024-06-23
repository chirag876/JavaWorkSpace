package com.api.design.Application.Car.Request.UpdateCar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.design.Application.Common.Interface.ICarDataAccess;
import com.api.design.Domain.Entities.Car;
import com.api.design.Mediator.RequestHandler;
@Component
public class UpdateCarRequestHandler implements RequestHandler<UpdateCarRequest, Integer> {

	@Autowired
	private ICarDataAccess _dataAccess;

	@Override
	public Integer handle(UpdateCarRequest request) {
		Car entity = _dataAccess.get(request.getId());
		entity.setName(request.getName());
		entity.setModel(request.getModel());

		_dataAccess.AddCar(entity);
		return entity.getId();

	}
}