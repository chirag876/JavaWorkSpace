package com.api.design.Application.Domain.Events;
import com.api.design.Application.Domain.Common.DomainEvent;
import com.api.design.Application.Domain.Entity.RetrievePolicy;

public class RetrievePolicyUpdatedEvent extends DomainEvent {
	
	private RetrievePolicy policy;

	public RetrievePolicyUpdatedEvent(RetrievePolicy policy) {
		this.policy = policy;		
	}
	public RetrievePolicy getContact() {
		return policy;
	}
}
