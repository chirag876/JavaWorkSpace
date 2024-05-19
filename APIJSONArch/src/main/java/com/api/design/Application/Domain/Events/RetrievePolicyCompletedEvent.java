// Define the package where this class resides
package com.api.design.Application.Domain.Events;

// Import the required classes
import com.api.design.Application.Domain.Common.DomainEvent;
import com.api.design.Application.Domain.Entity.RetrievePolicy;

// Define the RetrievePolicyCompletedEvent class that extends the DomainEvent class
public class RetrievePolicyCompletedEvent extends DomainEvent {
	
	// Define a private variable of type RetrievePolicy to store the policy
	private RetrievePolicy policy;

	// Define a constructor that takes a RetrievePolicy object as a parameter
	public RetrievePolicyCompletedEvent(RetrievePolicy policy) {
		// Initialize the policy variable with the provided policy object
		this.policy = policy;		
	}
	
	// Define a getter method to retrieve the policy object
	public RetrievePolicy getContact() {
		// Return the policy object
		return policy;
	}
	
}
