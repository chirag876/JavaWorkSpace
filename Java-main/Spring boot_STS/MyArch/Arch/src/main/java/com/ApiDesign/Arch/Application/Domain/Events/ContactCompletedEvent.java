package com.ApiDesign.Arch.Application.Domain.Events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ApiDesign.Arch.Application.Domain.Common.DomainEvent;
import com.ApiDesign.Arch.Application.Domain.Entity.Contact;
import com.ApiDesign.Arch.Infrasturture.Services.DomainEventService;

public class ContactCompletedEvent extends DomainEvent {
	
	
	Logger _logger = LoggerFactory.getLogger(ContactCompletedEvent.class);	
	private Contact contact;

	public ContactCompletedEvent(Contact contact) {
		_logger.info("ContactCompletedEvent- ");
		
		this.contact = contact;
	}

	public Contact getContact() {
		return contact;
	}	
	
}
