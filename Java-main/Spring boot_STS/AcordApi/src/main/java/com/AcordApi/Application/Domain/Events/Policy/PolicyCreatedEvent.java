package com.AcordApi.Application.Domain.Events.Policy;

import com.AcordApi.Application.Domain.Common.DomainEvent;
import com.AcordApi.Application.Domain.Entity.Policy;

public class PolicyCreatedEvent extends DomainEvent{
	
	private Policy policy;

	public PolicyCreatedEvent(Policy policy) {
		this.policy = policy;		
	}
	public Policy getContact() {
		return policy;
	}

}
