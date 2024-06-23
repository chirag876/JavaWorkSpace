package com.ApiDesign.Arch.Application.Contact.Command.CreateContactCommandHand;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.ApiDesign.Arch.Application.Common.Interface.IContact;
import com.ApiDesign.Arch.Application.Contact.Command.DeleteContactCommand;
import com.ApiDesign.Arch.Application.Domain.Entity.Contact;
import com.ApiDesign.Arch.Mediator.RequestHandler;
@Component
public class DeleteContactHandler implements RequestHandler<DeleteContactCommand,Integer> {

	private IContact _dataAccess;

	@Override
	public Integer handle(DeleteContactCommand request) {
		
		Contact entity =  	_dataAccess.GetById(request.getId());
		if(entity.getId()!=0) {
			_dataAccess.Delete(request.getId());
		}
		return request.getId();
	}

	@Override
	public UUID uhandle(DeleteContactCommand request) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
