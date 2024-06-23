package com.AcordApi.Application.Common.Model;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.AcordApi.Application.Common.Model.DomainEventNotification;
import com.AcordApi.Application.Domain.Common.DomainEvent;
import com.AcordApi.Mediator.Notification;

public class DomainEventNotification <TDomainEvent extends DomainEvent> implements Notification{
	
	// Create a Logger instance to log messages
		Logger _logger = LoggerFactory.getLogger(DomainEventNotification.class);	
		private List<TDomainEvent> domainEvent;
			
		// Constructor that takes a list of domain events as argument
		public DomainEventNotification(List<TDomainEvent> domainEvent) {
			// Log that the DomainEventNotification is being processed
			_logger.info("DomainEventNotification in process");
			this.domainEvent = domainEvent;
		}

		// Get the domain event
		public TDomainEvent getDomainEvent() {
			// Cast the list of domain events to a single domain event and return it
			return (TDomainEvent) domainEvent;
		}

}
