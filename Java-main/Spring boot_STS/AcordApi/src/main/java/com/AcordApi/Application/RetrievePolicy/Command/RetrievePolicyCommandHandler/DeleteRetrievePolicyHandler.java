package com.AcordApi.Application.RetrievePolicy.Command.RetrievePolicyCommandHandler;

//Import the required classes
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.AcordApi.Application.Common.Interface.IRetrievePolicyDataAccess;
import com.AcordApi.Application.RetrievePolicy.Request.DeleteRetrievePolicyRequest;
import com.AcordApi.Mediator.RequestHandler;

//Define the DeleteRetrievePolicyHandler class, which implements the RequestHandler interface
@Component
public class DeleteRetrievePolicyHandler implements RequestHandler<DeleteRetrievePolicyRequest, Integer>{
	
	// Inject the IRetrievePolicyDataAccess dependency
	@Autowired
	private IRetrievePolicyDataAccess _dataAccess;

	// Implement the handle method from the RequestHandler interface
	@Override
	public UUID uhandle(DeleteRetrievePolicyRequest command) {
		// Call the delete method of the data access layer with the ID provided in the command
		return _dataAccess.delete(command.getId());
	}

	@Override
	public Integer handle(DeleteRetrievePolicyRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

}
