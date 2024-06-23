package com.AcordApi.Application.Quote.Command.QuoteCommandHandler;

import java.util.UUID;

import com.AcordApi.Application.Domain.Events.Policy.PolicyCreatedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.AcordApi.Application.Quote.Request.CreateQuoteRequest;
import com.AcordApi.Infrastructure.DataAccess.QuoteDataAccess;
import com.AcordApi.Application.Domain.Entity.Quote;
import com.AcordApi.Application.Domain.Events.Quote.QuoteCompletedEvent;
import com.AcordApi.Application.Domain.Events.Quote.QuoteCreatedEvent;
import com.AcordApi.Mediator.RequestHandler;

@Component
public class CreateQuoteHandler implements RequestHandler<CreateQuoteRequest, Integer>{
	
	// An instance of the RetrievePolicyDataAccess object is injected through constructor injection
    @Autowired
    private QuoteDataAccess quote;

    // Constructor for CreateRetrievePolicyHandler that takes in an instance of RetrievePolicyDataAccess
    public CreateQuoteHandler(QuoteDataAccess quote) {

        this.quote = quote;

    }

    // This method creates a new RetrievePolicy entity, sets its properties and saves it to the database
    public UUID uhandle(CreateQuoteRequest request) {

		// Creating a new RetrievePolicy entity
    	Quote entity = new Quote();
		
		// Generating a new UUID for the RetrievePolicy entity
		UUID newId = UUID.randomUUID();
		
		// Setting the id property of the RetrievePolicy entity
		entity.setId(newId);
		
		UUID newQuoteId = UUID.randomUUID();
		
		entity.setQuoteId(newQuoteId);
		
		// Setting the retrievePolicyJsonB property of the RetrievePolicy entity
		entity.setQuoteJsonB(request.getQuoteJson());
		
		// Adding a new RetrievePolicyCreatedEvent to the RetrievePolicy entity's domainEvents list
		// This event represents the creation of a new RetrievePolicy entity
		entity.domainEvents.add(new QuoteCreatedEvent(entity));
		
		// Saving the RetrievePolicy entity to the database using the policy object from the data access layer
		quote.AddQuote(entity);
		
		// Adding a new RetrievePolicyCompletedEvent to the RetrievePolicy entity's domainEvents list
		// This event represents the completion of the RetrievePolicy creation process
		entity.domainEvents.add(new QuoteCompletedEvent(entity));
		
		// Returning the UUID of the newly created RetrievePolicy entity
		return request.getId();
	}

	@Override
	public Integer handle(CreateQuoteRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

}
