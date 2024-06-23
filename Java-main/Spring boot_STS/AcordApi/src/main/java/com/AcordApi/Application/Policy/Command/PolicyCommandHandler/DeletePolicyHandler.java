package com.AcordApi.Application.Policy.Command.PolicyCommandHandler;

//Import the required classes
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.AcordApi.Application.Common.Interface.IPolicyDataAccess;
import com.AcordApi.Application.Policy.Request.DeletePolicyRequest;
import com.AcordApi.Mediator.RequestHandler;

//Define the DeleteRetrievePolicyHandler class, which implements the RequestHandler interface
@Component
public class DeletePolicyHandler implements RequestHandler<DeletePolicyRequest, Integer>{
	
	// Inject the IRetrievePolicyDataAccess dependency
	@Autowired
	private IPolicyDataAccess _dataAccess;

	// Implement the handle method from the RequestHandler interface
	@Override
	public UUID uhandle(DeletePolicyRequest command) {
		// Call the delete method of the data access layer with the ID provided in the command
		return _dataAccess.delete(command.getId());
	}

	@Override
	public Integer handle(DeletePolicyRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

}
