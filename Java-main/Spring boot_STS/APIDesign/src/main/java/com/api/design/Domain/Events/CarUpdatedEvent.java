package com.api.design.Domain.Events;

import com.api.design.Domain.Common.DomainEvent;
import com.api.design.Domain.Entities.Car;

public class CarUpdatedEvent extends DomainEvent {
	private Car Car;

	public CarUpdatedEvent(Car car) {

		Car = car;
	}

	public Car getCar() {
		return Car;
	}
}
