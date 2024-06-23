package com.AcordApi.Application.Domain.Events.RetrievePolicy;

import com.AcordApi.Application.Domain.Common.DomainEvent;
import com.AcordApi.Application.Domain.Entity.RetrievePolicy;

public class RetrievePolicyCreatedEvent extends DomainEvent{
	
	private RetrievePolicy policy;

	public RetrievePolicyCreatedEvent(RetrievePolicy policy) {
		this.policy = policy;		
	}
	public RetrievePolicy getContact() {
		return policy;
	}

}
