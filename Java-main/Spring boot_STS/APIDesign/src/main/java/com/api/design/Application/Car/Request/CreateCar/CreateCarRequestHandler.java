package com.api.design.Application.Car.Request.CreateCar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.design.Domain.Events.CarCompletedEvent;
import com.api.design.Domain.Entities.Car;
import com.api.design.Domain.Events.CarCreatedEvent;
import com.api.design.Infrastructure.DataAccess.CarDataAccess;
import com.api.design.Mediator.RequestHandler;

@Component
public class CreateCarRequestHandler implements RequestHandler<CreateCarRequest, Integer> {

	@Autowired
	private CarDataAccess carDataAccess;

	public CreateCarRequestHandler(CarDataAccess carDataAccess) {
		this.carDataAccess = carDataAccess;

	}

	public Integer handle(CreateCarRequest request) {

		Car entity = new Car();
		entity.setId(request.getId());
		entity.setName(request.getName());
		entity.setModel(request.getModel());

		entity.domainEvents().add(new CarCreatedEvent(entity));
		carDataAccess.AddCar(entity);
		entity.domainEvents().add(new CarCompletedEvent(entity));

		return request.getId();

	}
}
