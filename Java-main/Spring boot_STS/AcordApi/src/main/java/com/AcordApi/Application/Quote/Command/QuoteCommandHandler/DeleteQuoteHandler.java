package com.AcordApi.Application.Quote.Command.QuoteCommandHandler;

//Import the required classes
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.AcordApi.Application.Common.Interface.IQuoteDataAccess;
import com.AcordApi.Application.Quote.Request.DeleteQuoteRequest;
import com.AcordApi.Mediator.RequestHandler;

//Define the DeleteRetrievePolicyHandler class, which implements the RequestHandler interface
@Component
public class DeleteQuoteHandler implements RequestHandler<DeleteQuoteRequest, Integer>{
	
	// Inject the IRetrievePolicyDataAccess dependency
	@Autowired
	private IQuoteDataAccess _dataAccess;

	// Implement the handle method from the RequestHandler interface
	@Override
	public UUID uhandle(DeleteQuoteRequest command) {
		// Call the delete method of the data access layer with the ID provided in the command
		return _dataAccess.delete(command.getId());
	}

	@Override
	public Integer handle(DeleteQuoteRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

}
