package com.api.design.Domain.Events;

import com.api.design.Domain.Common.DomainEvent;
import com.api.design.Domain.Entities.Car;

public class CarCreatedEvent extends DomainEvent {

	private Car Car;

	public CarCreatedEvent(Car car) {
		this.Car = car;
	}

	public Car getCar() {
		return Car;
	}
}
