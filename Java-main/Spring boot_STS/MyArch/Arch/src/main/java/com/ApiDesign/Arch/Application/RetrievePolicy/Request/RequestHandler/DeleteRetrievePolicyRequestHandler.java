package com.ApiDesign.Arch.Application.RetrievePolicy.Request.RequestHandler;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ApiDesign.Arch.Application.Common.Interface.IContact;
import com.ApiDesign.Arch.Application.Common.Interface.IRetrievePolicyDataAccess;
import com.ApiDesign.Arch.Application.Contact.Command.DeleteContactCommand;
import com.ApiDesign.Arch.Application.Domain.Entity.Contact;
import com.ApiDesign.Arch.Application.Domain.Entity.RetrievePolicy;
import com.ApiDesign.Arch.Application.RetrievePolicy.Request.DeleteRetrievePolicyRequest;
import com.ApiDesign.Arch.Mediator.RequestHandler;

@Component
public class DeleteRetrievePolicyRequestHandler implements RequestHandler<DeleteRetrievePolicyRequest,UUID> {

	
	private IRetrievePolicyDataAccess _dataAccess;

	@Override
	public UUID handle(DeleteRetrievePolicyRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UUID uhandle(DeleteRetrievePolicyRequest command) {
		return _dataAccess.Delete(command.getId());
	}
	

	
}

