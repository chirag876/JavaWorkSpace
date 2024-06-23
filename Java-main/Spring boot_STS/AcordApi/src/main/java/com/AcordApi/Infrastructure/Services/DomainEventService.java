package com.AcordApi.Infrastructure.Services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Component;

import com.AcordApi.Application.Common.Model.DomainEventNotification;
import com.AcordApi.Application.Common.Interface.IDomainEventService;
import com.AcordApi.Application.Domain.Common.DomainEvent;
import com.AcordApi.Infrastructure.Services.DomainEventService;
import com.AcordApi.Mediator.IPublish;
import com.AcordApi.Mediator.Notification;

@Component
public class DomainEventService implements IDomainEventService{
	
	// Mediator instance to publish notifications
		private IPublish _meditor;

		// Logger instance for logging
		Logger _logger = LoggerFactory.getLogger(DomainEventService.class);

		// Constructor with IPublish dependency injection
		public DomainEventService(IPublish _meditor) {
			this._meditor = _meditor;
		}

		// Default constructor
		public DomainEventService() {
		}

		// Method to publish a list of domain events
		@Override
		public void Publish(List<DomainEvent> domainEvent) {
			_logger.info("Publishing domain event. Event -" + domainEvent);

			// Get the notification corresponding to the domain event
//				Notification notification = GetNotificationCorrespondingToDomainEvent(domainEvent);
	//
//				// Publish the notification using mediator
//				_meditor.Publish(notification);
			GetNotificationCorrespondingToDomainEvent(domainEvent);
//			 _meditor.Publish(GetNotificationCorrespondingToDomainEvent(domainEvent));
		}

		// Method to get notification corresponding to a domain event
		private Notification GetNotificationCorrespondingToDomainEvent(List<DomainEvent> domainEvent) {
			// Create a DomainEventNotification with the domain event list
			DomainEventNotification<DomainEvent> notification = new DomainEventNotification<>(domainEvent);
			return notification;
		}

}
