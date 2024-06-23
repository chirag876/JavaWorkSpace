package com.api.design.Application.Car.EventHandlers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.api.design.Application.Common.Models.DomainEventNotification;
import com.api.design.Domain.Events.CarDeletedEvent;
import com.api.design.Mediator.NotificationHandler;

public class CarDeletedEventHandler implements NotificationHandler<DomainEventNotification<CarDeletedEvent>> {

	Logger LOGGER = LoggerFactory.getLogger(CarDeletedEventHandler.class);

	public CarDeletedEventHandler(Logger lOGGER) {
		LOGGER = lOGGER;
	}

	@Override
	public void handle(List<DomainEventNotification<CarDeletedEvent>> notification) {
		LOGGER.info("Domain Event: {}", notification.getClass().getSimpleName());
//		Object domainEvents = notification.getDomainEvent();
//		return (Task) domainEvents;
		System.out.print(true);
	}
}