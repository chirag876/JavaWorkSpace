package com.api.design.Application.Car.EventHandlers;



import com.api.design.Application.Common.Models.DomainEventNotification;
import com.api.design.Domain.Events.CarCreatedEvent;
import com.api.design.Mediator.NotificationHandler;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CarCreatedEventHandler implements NotificationHandler<DomainEventNotification<CarCreatedEvent>> {

	Logger LOGGER = LoggerFactory.getLogger(CarCreatedEventHandler.class);

	public CarCreatedEventHandler(Logger lOGGER) {
		LOGGER = lOGGER;
	}

	@Override
	public void handle(List<DomainEventNotification<CarCreatedEvent>>notification) {
		LOGGER.info("Domain Event: {}", notification.getClass().getSimpleName());
//		Object domainEvents = notification.getDomainEvent();
//		return (Task) domainEvents;
		System.out.print(true);
	}
}
