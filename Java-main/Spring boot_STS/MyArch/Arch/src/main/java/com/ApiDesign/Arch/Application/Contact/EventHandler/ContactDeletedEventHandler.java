package com.ApiDesign.Arch.Application.Contact.EventHandler;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ApiDesign.Arch.Application.Common.Model.DomainEventNotification;
import com.ApiDesign.Arch.Application.Domain.Events.ContactDeleteEvent;
import com.ApiDesign.Arch.Mediator.NotificationHandler;

public class ContactDeletedEventHandler implements NotificationHandler<DomainEventNotification<ContactDeleteEvent>>{

		Logger _logger = LoggerFactory.getLogger(ContactDeletedEventHandler.class);	
	
	
	
	public ContactDeletedEventHandler(Logger _logger) {
		this._logger = _logger;
	}
	
	//Handler will receive Response  
	

	@Override
	public void handle(List<DomainEventNotification<ContactDeleteEvent>> notification) {
		
		_logger.info("Domain Event: "+  notification);
		
	}
}
