package com.AcordApi.Application.Quote.Command.QuoteCommandHandler;

//Import the required classes
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.AcordApi.Application.Common.Interface.IQuoteDataAccess;
import com.AcordApi.Application.Domain.Entity.Quote;
import com.AcordApi.Application.Quote.Request.UpdateQuoteRequest;
import com.AcordApi.Mediator.RequestHandler;

//Define the UpdateRetrievePolicyQueryHandler class, which implements the RequestHandler interface
@Component
public class UpdateQuoteQueryHandler implements RequestHandler<UpdateQuoteRequest, Integer>{
	
	// Inject the IRetrievePolicyDataAccess dependency
	@Autowired
	private IQuoteDataAccess _dataAccess;

	// Implement the handle method from the RequestHandler interface
	@Override
	public UUID uhandle(UpdateQuoteRequest request) {
		// Retrieve the RetrievePolicy object from the data access layer by its ID
		Quote entity = _dataAccess.GetById(request.getId());
		// Set the JSON data of the retrieved entity to the JSON data provided in the request
		entity.setQuoteJsonB(request.getQuoteJson());

		// Update the entity in the database
		// _dataAccess.Update(entity);
		_dataAccess.AddQuote(entity);
		// Return the ID of the updated entity
		return entity.getId();
	}

	@Override
	public Integer handle(UpdateQuoteRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

}
