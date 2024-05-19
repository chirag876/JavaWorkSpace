package com.api.design.Application.RetrievePolicy.EventHandlers;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.api.design.Application.Common.Model.DomainEventNotification;
import com.api.design.Application.Domain.Events.RetrievePolicyDeletedEvent;
import com.api.design.Mediator.NotificationHandler;

public class RetrievePolicyDeletedEventHandler implements NotificationHandler<DomainEventNotification<RetrievePolicyDeletedEvent>> {

	Logger _logger = LoggerFactory.getLogger(RetrievePolicyDeletedEventHandler.class);	



public RetrievePolicyDeletedEventHandler(Logger _logger) {
	this._logger = _logger;
}

//Handler will receive Response  


@Override
public void handle(List<DomainEventNotification<RetrievePolicyDeletedEvent>> notification) {
	
	_logger.info("Domain Event: "+  notification);
	
}
}