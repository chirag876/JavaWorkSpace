package com.ApiDesign.Arch.Application.Common.Model;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ApiDesign.Arch.Application.Domain.Common.DomainEvent;
import com.ApiDesign.Arch.Infrasturture.DataAccess.ContactDataAccess;
import com.ApiDesign.Arch.Mediator.Notification;

public class DomainEventNotification <TDomainEvent extends DomainEvent >  implements Notification {
	
	Logger _logger = LoggerFactory.getLogger(DomainEventNotification.class);	
	private List<TDomainEvent> domainEvent;
		

	public DomainEventNotification(List<TDomainEvent> domainEvent) {
		_logger.info("DomainEventNotification ");
		this.domainEvent = domainEvent;
	}


	public TDomainEvent getDomainEvent() {
		return (TDomainEvent) domainEvent;
	}
	
	
	
}

//public class DomainEventNotification<TDomainEvent extends DomainEvent> implements Notification {
//    private final TDomainEvent domainEvent;
//
//    public DomainEventNotification(TDomainEvent domainEvent) {
//        this.domainEvent = domainEvent;
//    }
//
//    public TDomainEvent getDomainEvent() {
//        return domainEvent;
//    }
//}

