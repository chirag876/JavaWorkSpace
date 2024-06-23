package com.ApiDesign.Arch.Application.Contact.EventHandler;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ApiDesign.Arch.Application.Common.Model.DomainEventNotification;
import com.ApiDesign.Arch.Application.Domain.Events.ContactCreatedEvent;
import com.ApiDesign.Arch.Application.Domain.Events.UpdateContactEvent;
import com.ApiDesign.Arch.Mediator.NotificationHandler;

public class UpdateContactEventHandler  implements NotificationHandler<DomainEventNotification<UpdateContactEvent>> {
	
	Logger _logger = LoggerFactory.getLogger(ContactCreatedEventHandler.class);	
	
	
	
	public UpdateContactEventHandler(Logger _logger) {
		this._logger = _logger;
	}
	
	//Handler will receive Response  
	

	@Override
	public void handle(List<DomainEventNotification<UpdateContactEvent>> notification) {
		
		_logger.info("Domain Event: "+  notification);
		
	}

}
