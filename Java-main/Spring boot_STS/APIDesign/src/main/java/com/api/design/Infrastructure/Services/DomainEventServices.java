package com.api.design.Infrastructure.Services;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.api.design.Application.Common.Models.DomainEventNotification;
import com.api.design.Application.Common.Interface.IDomainEventService;
import com.api.design.Domain.Common.DomainEvent;
import com.api.design.Mediator.IPublish;
import com.api.design.Mediator.Notification;

@Component
public class DomainEventServices implements IDomainEventService {

	Logger _logger = LoggerFactory.getLogger(DomainEventServices.class);

	public IPublish _meditor;

	public DomainEventServices(IPublish _meditor) {
		this._meditor = _meditor;

	}

	public DomainEventServices() {
	}

	public IPublish get_meditor() {
		return _meditor;
	}

	public void set_meditor(IPublish meditor) {
		_meditor = meditor;
	}

	@Override
	public void Publish(List<DomainEvent> domainEvent) {
		_logger.info("Publishing domain event. Event - {event}", domainEvent);
		 GetNotificationCorrespondingToDomainEvent(domainEvent);
		//_meditor.Publish(GetNotificationCorrespondingToDomainEvent(domainEvent));
	}

	public Notification GetNotificationCorrespondingToDomainEvent(List<DomainEvent> domainEvent) {
		// DomainEventNotification notification = new
		// DomainEventNotification(domainEvent);
		DomainEventNotification<DomainEvent> notification = new DomainEventNotification<>(domainEvent);
		// return (Notification) domainEvent;
		return notification;
	}

}
