package com.api.design.Application.Common.Interface;

import java.util.List;


import com.api.design.Domain.Common.DomainEvent;

public interface IDomainEventService {
	void Publish(List<DomainEvent> domainEvent);
}
