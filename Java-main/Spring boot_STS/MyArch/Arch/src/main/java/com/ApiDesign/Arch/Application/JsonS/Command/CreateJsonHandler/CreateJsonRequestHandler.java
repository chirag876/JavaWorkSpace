package com.ApiDesign.Arch.Application.JsonS.Command.CreateJsonHandler;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ApiDesign.Arch.Application.Common.Interface.IJsonS;
import com.ApiDesign.Arch.Application.Domain.Entity.JsonS;
import com.ApiDesign.Arch.Application.JsonS.Command.CreateJsonSRequest;
import com.ApiDesign.Arch.Mediator.RequestHandler;
@Component
public class CreateJsonRequestHandler implements RequestHandler<CreateJsonSRequest,Integer> {

	@Autowired 
	private IJsonS jsonDataAccess;

	public CreateJsonRequestHandler(IJsonS jsonDataAccess) {
		super();
		this.jsonDataAccess = jsonDataAccess;
	}

	@Override
	public Integer handle(CreateJsonSRequest request) {
		JsonS entity = new JsonS();
		
		entity.setRetrievePolicyJsonB(( request.getRetrievePolicyJson()));
		jsonDataAccess.AddJson(entity);
		return 1;
		
	}

	@Override
	public UUID uhandle(CreateJsonSRequest request) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
