package com.ApiDesign.Arch.Application.Contact.EventHandler;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Component;

import com.ApiDesign.Arch.Application.Common.Model.DomainEventNotification;
import com.ApiDesign.Arch.Application.Domain.Events.ContactCreatedEvent;
import com.ApiDesign.Arch.Infrasturture.Services.DomainEventService;
import com.ApiDesign.Arch.Mediator.NotificationHandler;
@Component
public class ContactCreatedEventHandler implements NotificationHandler<DomainEventNotification<ContactCreatedEvent>>{
	Logger _logger = LoggerFactory.getLogger(ContactCreatedEventHandler.class);	
	
	ContactCreatedEventHandler(){}
	
	public ContactCreatedEventHandler(Logger _logger) {
		this._logger = _logger;
	}
	
	//Handler will receive Response  
	

	@Override
	public void handle(List<DomainEventNotification<ContactCreatedEvent>> notification) {
		
		_logger.info("Domain Event: "+  notification);
		
	}
}
