package com.AcordApi.Application.Common.Interface;

import java.util.List;

import com.AcordApi.Application.Domain.Common.DomainEvent;

public interface IHasDomainEvent {
	
	public List<DomainEvent> domainEvents();

}
