package com.api.design.Application.Common.Models;

import java.util.List;

import com.api.design.Domain.Common.DomainEvent;
import com.api.design.Mediator.Notification;

public class DomainEventNotification <TDomainEvent extends DomainEvent>  implements Notification {
	
	//private TDomainEvent domainEvent;
	private List<TDomainEvent> domainEvent;

	public DomainEventNotification(List<TDomainEvent> domainEvent) {
		
		this.domainEvent = domainEvent;
	}

	public TDomainEvent getDomainEvent() {
	    if (domainEvent != null && !domainEvent.isEmpty()) {
	        return domainEvent.get(0);
	    } else {
	        return null; // or throw an exception
	    }

	}
}
//	public TDomainEvent getDomainEvent() {
//		//return domainEvent;
//		return (TDomainEvent) domainEvent;
//	}
//
//	
//	
//	
//}