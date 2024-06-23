package com.ApiDesign.Arch.Application.Domain.Events;

import com.ApiDesign.Arch.Application.Domain.Common.DomainEvent;
import com.ApiDesign.Arch.Application.Domain.Entity.Contact;

public class ContactDeleteEvent extends DomainEvent {
	
	private Contact contact;

	public ContactDeleteEvent(Contact contact) {
		this.contact = contact;		
	}
	public Contact getContact() {
		return contact;
	}

}
