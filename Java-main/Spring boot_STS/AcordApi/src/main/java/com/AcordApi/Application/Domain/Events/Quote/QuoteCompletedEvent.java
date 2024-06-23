package com.AcordApi.Application.Domain.Events.Quote;

//Import the required classes
import com.AcordApi.Application.Domain.Common.DomainEvent;
import com.AcordApi.Application.Domain.Entity.Quote;

//Define the RetrievePolicyCompletedEvent class that extends the DomainEvent class
public class QuoteCompletedEvent extends DomainEvent{
	
	// Define a private variable of type RetrievePolicy to store the policy
	private Quote quote;

	// Define a constructor that takes a RetrievePolicy object as a parameter
	public QuoteCompletedEvent(Quote quote) {
		// Initialize the policy variable with the provided policy object
		this.quote = quote;		
	}
	
	// Define a getter method to retrieve the policy object
	public Quote getContact() {
		// Return the policy object
		return quote;
	}

}
