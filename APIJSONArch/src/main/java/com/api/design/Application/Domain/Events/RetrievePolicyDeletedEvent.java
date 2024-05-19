package com.api.design.Application.Domain.Events;

import com.api.design.Application.Domain.Common.DomainEvent;
import com.api.design.Application.Domain.Entity.RetrievePolicy;

public class RetrievePolicyDeletedEvent extends DomainEvent {
	
	private RetrievePolicy policy;

	public RetrievePolicyDeletedEvent(RetrievePolicy policy) {
		this.policy = policy;		
	}
	public RetrievePolicy getContact() {
		return policy;
	}
}
