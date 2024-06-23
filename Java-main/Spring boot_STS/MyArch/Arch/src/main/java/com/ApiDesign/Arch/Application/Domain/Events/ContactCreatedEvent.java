package com.ApiDesign.Arch.Application.Domain.Events;

import com.ApiDesign.Arch.Application.Domain.Common.DomainEvent;
import com.ApiDesign.Arch.Application.Domain.Entity.Contact;

public class ContactCreatedEvent extends DomainEvent {
	
	private Contact contact;

	public ContactCreatedEvent(Contact contact) {
		this.contact = contact;		
	}
	public Contact getContact() {
		return contact;
	}
	
}
