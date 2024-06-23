package com.ApiDesign.Arch.Application.Domain.Events;

import org.springframework.beans.factory.annotation.Autowired;

import com.ApiDesign.Arch.Application.Domain.Common.DomainEvent;
import com.ApiDesign.Arch.Application.Domain.Entity.RetrievePolicy;

public class RetrievePolicyCreatedEvent extends DomainEvent {
	@Autowired
	private RetrievePolicy policy;

	public RetrievePolicyCreatedEvent(RetrievePolicy policy) {
		this.policy = policy;		
	}
	public RetrievePolicy getContact() {
		return policy;
	}
}
