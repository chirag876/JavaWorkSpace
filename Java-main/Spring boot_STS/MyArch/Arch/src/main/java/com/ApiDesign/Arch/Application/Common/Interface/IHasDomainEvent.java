package com.ApiDesign.Arch.Application.Common.Interface;

import java.util.ArrayList;
import java.util.List;

import com.ApiDesign.Arch.Application.Domain.Common.DomainEvent;


public interface IHasDomainEvent {

	public List<DomainEvent> domainEvents();
	
//	public List<DomainEvent> getDomainEvents();
//	public void setDomainEvents(List<DomainEvent> domainEvents);
	
	
}
