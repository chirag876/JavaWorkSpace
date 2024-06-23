package com.api.design.Application.Car.EventHandlers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.api.design.Application.Common.Models.DomainEventNotification;
import com.api.design.Domain.Events.CarUpdatedEvent;
import com.api.design.Mediator.NotificationHandler;

public class CarUpdatedEventHandler  implements NotificationHandler<DomainEventNotification<CarUpdatedEvent>> {

	Logger LOGGER = LoggerFactory.getLogger(CarDeletedEventHandler.class);

	public CarUpdatedEventHandler(Logger lOGGER) {
		LOGGER = lOGGER;
	}

	@Override
	public void handle(List<DomainEventNotification<CarUpdatedEvent>> notification) {
		LOGGER.info("Domain Event: {}", notification.getClass().getSimpleName());
//		Object domainEvents = notification.getDomainEvent();
//		return (Task) domainEvents;
		System.out.print(true);
	}
}
