package com.api.design.Application.Common.Interface;

import java.util.List;

import com.api.design.Application.Domain.Common.DomainEvent;

public interface IDomainEventService {

	/**
	 * This method publishes the given list of domain events.
	 * 
	 * @param domainEvent a list of DomainEvent objects to be published
	 */
	void Publish(List<DomainEvent> domainEvent);
}
