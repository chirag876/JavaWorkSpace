package com.ApiDesign.Arch.Application.Contact.Command.CreateContactCommandHand;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ApiDesign.Arch.Application.Common.Interface.IContact;
import com.ApiDesign.Arch.Application.Contact.Command.UpdateContactRequest;
import com.ApiDesign.Arch.Application.Contact.EventHandler.ContactCreatedEventHandler;
import com.ApiDesign.Arch.Application.Domain.Entity.Contact;
import com.ApiDesign.Arch.Application.Domain.Events.ContactCreatedEvent;
import com.ApiDesign.Arch.Mediator.RequestHandler;

@Component
public class UpdateContactHandler implements RequestHandler<UpdateContactRequest, Integer> {

	@Autowired
	private IContact _dataAccess;
	Logger _logger = LoggerFactory.getLogger(UpdateContactHandler.class);	

	@Override
	public Integer handle(UpdateContactRequest request) {
		Contact entity = _dataAccess.GetById(request.getId());
		if(request.getId()!=0) {
			
			_logger.info("Id: "+request.getId(),"Name:"+ request.getName());
			
		
		entity.setName(request.getName());
		entity.setPhone(request.getPhone());
		
		entity.domainEvents().add(new ContactCreatedEvent(entity));
		
		_dataAccess.Update(entity);
		//entity.domainEvents().add(new ContactCreatedEvent(entity));
		}
		return entity.getId();
		 
	}

	@Override
	public UUID uhandle(UpdateContactRequest request) {
		// TODO Auto-generated method stub
		return null;
	}	
	
	
	
}
