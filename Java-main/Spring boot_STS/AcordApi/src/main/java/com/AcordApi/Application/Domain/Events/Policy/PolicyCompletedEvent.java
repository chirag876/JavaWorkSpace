package com.AcordApi.Application.Domain.Events.Policy;

//Import the required classes
import com.AcordApi.Application.Domain.Common.DomainEvent;
import com.AcordApi.Application.Domain.Entity.Policy;

//Define the RetrievePolicyCompletedEvent class that extends the DomainEvent class
public class PolicyCompletedEvent extends DomainEvent{
	
	// Define a private variable of type RetrievePolicy to store the policy
	private Policy policy;

	// Define a constructor that takes a RetrievePolicy object as a parameter
	public PolicyCompletedEvent(Policy policy) {
		// Initialize the policy variable with the provided policy object
		this.policy = policy;		
	}
	
	// Define a getter method to retrieve the policy object
	public Policy getContact() {
		// Return the policy object
		return policy;
	}

}
