package com.api.design.Application.Common.Interface;

import java.util.List;

import com.api.design.Domain.Common.DomainEvent;

public interface IHasDomainEvent {
	public List<DomainEvent> domainEvents();
}
