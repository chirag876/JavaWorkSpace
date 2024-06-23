package com.ApiDesign.Arch.Application.Domain.Events;
import com.ApiDesign.Arch.Application.Domain.Common.DomainEvent;
import com.ApiDesign.Arch.Application.Domain.Entity.RetrievePolicy;

public class RetrievePolicyCompletedEvent extends DomainEvent {
	
	private RetrievePolicy policy;

	public RetrievePolicyCompletedEvent(RetrievePolicy policy) {
		this.policy = policy;		
	}
	public RetrievePolicy getContact() {
		return policy;
	}
	
}
