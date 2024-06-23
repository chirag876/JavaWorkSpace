package com.AcordApi.Application.Policy.Command.PolicyCommandHandler;

//Import the required classes
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.AcordApi.Application.Common.Interface.IPolicyDataAccess;
import com.AcordApi.Application.Domain.Entity.Policy;
import com.AcordApi.Application.Policy.Request.UpdatePolicyRequest;
import com.AcordApi.Mediator.RequestHandler;

//Define the UpdateRetrievePolicyQueryHandler class, which implements the RequestHandler interface
@Component
public class UpdatePolicyQueryHandler implements RequestHandler<UpdatePolicyRequest, Integer>{
	
	// Inject the IRetrievePolicyDataAccess dependency
	@Autowired
	private IPolicyDataAccess _dataAccess;

	// Implement the handle method from the RequestHandler interface
	@Override
	public UUID uhandle(UpdatePolicyRequest request) {
		// Retrieve the RetrievePolicy object from the data access layer by its ID
		Policy entity = _dataAccess.GetById(request.getId());
		// Set the JSON data of the retrieved entity to the JSON data provided in the request
		entity.setPolicyJsonB(request.getPolicyJson());

		// Update the entity in the database
		// _dataAccess.Update(entity);
		_dataAccess.AddPolicy(entity);
		// Return the ID of the updated entity
		return entity.getId();
	}

	@Override
	public Integer handle(UpdatePolicyRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

}
