package com.api.design.Application.Domain.Events;

import com.api.design.Application.Domain.Common.DomainEvent;
import com.api.design.Application.Domain.Entity.RetrievePolicy;

public class RetrievePolicyCreatedEvent extends DomainEvent {
	
	private RetrievePolicy policy;

	public RetrievePolicyCreatedEvent(RetrievePolicy policy) {
		this.policy = policy;		
	}
	public RetrievePolicy getContact() {
		return policy;
	}
}
