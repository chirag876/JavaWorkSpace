package com.api.design.Domain.Events;

import com.api.design.Domain.Common.DomainEvent;
import com.api.design.Domain.Entities.Car;

public class CarCompletedEvent extends DomainEvent  {

	private Car Car;

	public CarCompletedEvent(Car car) {

		this.Car = car;
	}

	public Car getCar() {
		return Car;
	}

}
