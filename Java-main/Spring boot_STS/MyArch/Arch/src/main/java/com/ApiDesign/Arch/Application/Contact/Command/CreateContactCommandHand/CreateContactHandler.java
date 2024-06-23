package com.ApiDesign.Arch.Application.Contact.Command.CreateContactCommandHand;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.DomainEvents;
import org.springframework.stereotype.Component;

import com.ApiDesign.Arch.Application.Common.Interface.IContact;
import com.ApiDesign.Arch.Application.Contact.Command.CreateContactRequest;
import com.ApiDesign.Arch.Application.Domain.Common.DomainEvent;
import com.ApiDesign.Arch.Application.Domain.Entity.Contact;
import com.ApiDesign.Arch.Application.Domain.Events.ContactCompletedEvent;
import com.ApiDesign.Arch.Application.Domain.Events.ContactCreatedEvent;
import com.ApiDesign.Arch.Infrasturture.DataAccess.ContactDataAccess;
import com.ApiDesign.Arch.Infrasturture.Services.DomainEventService;
import com.ApiDesign.Arch.Mediator.RequestHandler;
import com.google.gson.Gson;

@Component
public class CreateContactHandler implements RequestHandler<CreateContactRequest, Integer>{
	
	@Autowired 
	private IContact contactDataAccess;

	
	public CreateContactHandler(ContactDataAccess contactDataAccess) {
		
		this.contactDataAccess = contactDataAccess;
		
	}
	
	//Assign Requested Contact value
	public Integer handle(CreateContactRequest request) {	
	
		
		Contact entity = new Contact();
		entity.setId(request.getId());
		entity.setName(request.getName());
		entity.setPhone(request.getPhone());
//		contact.setId(request.getId());
//		contact.setName(request.getName());
//		contact.setPhone(request.getPhone());
		
		// Adding DomainEvent to Contact Object
		
		entity.domainEvents().add(new ContactCreatedEvent(entity));
		// Add Requested to Contact 
		contactDataAccess.AddContact(entity);
		
		entity.domainEvents().add(new ContactCompletedEvent(entity));

		return request.getId();
	}

	@Override
	public UUID uhandle(CreateContactRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

} 

