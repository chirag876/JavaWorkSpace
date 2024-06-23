package com.AcordApi.Application.RetrievePolicy.Command.RetrievePolicyCommandHandler;

//Import the required classes
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.AcordApi.Application.Common.Interface.IRetrievePolicyDataAccess;
import com.AcordApi.Application.Domain.Entity.RetrievePolicy;
import com.AcordApi.Application.RetrievePolicy.Request.UpdateRetrievePolicyRequest;
import com.AcordApi.Mediator.RequestHandler;

//Define the UpdateRetrievePolicyQueryHandler class, which implements the RequestHandler interface
@Component
public class UpdateRetrievePolicyQueryHandler implements RequestHandler<UpdateRetrievePolicyRequest, Integer>{
	
	// Inject the IRetrievePolicyDataAccess dependency
	@Autowired
	private IRetrievePolicyDataAccess _dataAccess;

	// Implement the handle method from the RequestHandler interface
	@Override
	public UUID uhandle(UpdateRetrievePolicyRequest request) {
		// Retrieve the RetrievePolicy object from the data access layer by its ID
		RetrievePolicy entity = _dataAccess.GetById(request.getId());
		// Set the JSON data of the retrieved entity to the JSON data provided in the request
		entity.setRetrievePolicyJsonB(request.getRetrievePolicyJson());

		// Update the entity in the database
		// _dataAccess.Update(entity);
		_dataAccess.AddPolicy(entity);
		// Return the ID of the updated entity
		return entity.getId();
	}

	@Override
	public Integer handle(UpdateRetrievePolicyRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

}
